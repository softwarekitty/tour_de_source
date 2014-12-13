import sqlite3
import rewinder
import urllib2
import base64
import json
import re
import dateutil.parser
import calendar
import time
import sh
import os
import logging
import random

'''*Sourcer interface:
        *Sourcer(rewinder_type) rewinder_type could be Version, Weekly, 1%, first, last, etc.  some way to choose what commits to choose from all possible commits.  For now we don't do anything with this value - placeholder.  Also, we don't want to do any long running online processes in the initialization - just get ready

        initialize_report(report_db)
            it should give the scanner some way to reference
            what the scanner has scanned - ideally enough to go back
            there if needed

        hasNext()
            prepares for an advance to the next project, if needed
            returns true if there is a next project from this source


        next()
            provides a rewinder for the next project
            the meta, data and source tables should be populated on rewinder creation in the Sourcer that creates them
'''

'''
Note about using lists as a stack:
pop() is O(1), append() is O(1), reverse() is O(n), pop(0) is O(n).
For logical consistency, I want next() to always get the next larger repoID.  And when used in rewinders, I want rewind() to start at the most recent commit and go backwards.  When building both of these lists the items appear in that order and I append as I go through them and then reverse the list after everything is added, because python lists pop at the tail.  We could follow the FIFO of a queue and pop(0) without reversing, but that technique would be O(n^2), whereas this technique is O(n), although it probably doesn't matter much.
'''


class GithubPythonSourcer:
    META_TABLE_NAME = "GithubMeta"
    DATA_TABLE_NAME = "GithubData"

    def __init__(self, rewinder_type):
        self.rewinder_type = rewinder_type
        self.exhausted = False

        # for testing only - this makes the first Python project very small
        self.last = 15249308
        self.repos = []
        self.log("initialized")

    def isExhausted(self):
        return bool(self.exhausted)

    def log(self, msg=""):
        state = "GiPyS - last: " + str(self.last) + " len(repos): " + str(len(self.repos)) + " :: "
        if self.exhausted:
            msg = "exhausted:True " + msg
            logging.info(state + msg)
        else:
            logging.debug(state + msg)

    # returns a rewinder for the next repo
    def next(self, path, report_db):
        self.log("next")
        if len(self.repos) == 0:
            self.refresh_repos(self.last)
        if self.exhausted is True:
            return None
        self.last = self.repos.pop()
        return self.getRewinder(self.last, path, report_db)

    def get_json(self, url):

        attempt_counter = 0
        attempt_limit = 5
        backoff_counter = 1
        max_waitS = 180

        # keep trying until we get the json from github
        while True:
            emergency_waitS = 2 ** backoff_counter
            if emergency_waitS < max_waitS:
                backoff_counter += 1
            else:
                emergency_waitS = max_waitS

            try:
                # first check rate limit - does not count against you
                check_limit_url = "https://api.github.com/rate_limit"
                rateJSON = json.load(urllib2.urlopen(self.get_authorized_request(check_limit_url)))
                limit_remaining = rateJSON['resources']['core']['remaining']

                # don't push the rate limit if none remain - wait for reset
                if limit_remaining <= 0:
                    limit_resetS = rateJSON['resources']['core']['reset']
                    nowS = calendar.timegm(time.timegm())
                    time_to_waitS = limit_resetS - (nowS + 2)
                    logging.info("GiPyS - get_json, limit_remaining: " + str(limit_remaining) + " url: " + url + " backoff: " + str(backoff_counter) + " ttwS: " + str(time_to_waitS))
                    time.sleep(time_to_waitS)

                urlJSON = json.load(urllib2.urlopen(self.get_authorized_request(url)))
                logging.debug("GiPyS - get_json Success, url: " + url + " limit_remaining: " + str(limit_remaining))
                return urlJSON
            except urllib2.HTTPError, e:
                logging.error("GiPyS - get_json, HTTPError!!!")
            except Exception as e:
                logging.error("GiPyS - get_json, Problem with getting json " + str(e))

            # break out of this cycle for troublesome urls
            attempt_counter += 1
            if attempt_counter >= attempt_limit:
                logging.error("GiPyS - get_json, Giving up on url " + url + " after " + str(attempt_counter) + " attempts")
                raise Exception("this url is not worth the trouble: " + url)

            # back off a random time to avoid looking like such a robot
            backoffS = random.randrange(emergency_waitS)
            logging.warning("GiPyS - get_json, backing off with backoffS: " + str(backoffS) + " attempt: " + str(attempt_counter) + "/" + str(attempt_limit) + " url: " + url)
            time.sleep(backoffS)

    def get_authorized_request(self, url):
        encoded64 = base64.encodestring("investigationBot:cro0thiezlutrl").replace('\n', '')
        request = urllib2.Request(url)
        request.add_header("Authorization", "Basic %s" % encoded64)
        return request

    # this is a placeholder for adding rewinders to this sourcer
    def getRewinder(self, repoID, path, report_db):
        if self.rewinder_type == "MasterAndTags":
            return self.getGitMasterAndTagsRewinder(repoID, path, report_db)
        else:
            return None

    def getGitMasterAndTagsRewinder(self, repoID, path, report_db):
        self.log("geGiMaATaRe, repoID: " + str(repoID))

        # using repoID and github api, find masterSHA, repoJSON, tagJSON, masterJSON
        repoJSON = self.get_json("https://api.github.com/repositories/" + str(repoID))
        tagJSON = self.get_json(repoJSON['tags_url'])
        masterURL = re.sub(r'({.*)$', '/' + repoJSON['default_branch'], repoJSON['branches_url'])
        masterJSON = self.get_json(masterURL)
        masterSHA = masterJSON['commit']['sha']

        # populate the meta table with this project's meta information
        metaID = self.record_meta(repoID, masterSHA, repoJSON, tagJSON, masterJSON, report_db)

        # populate the data table with masterDateMS, masterSHA, metaID
        masterDate = masterJSON['commit']['commit']['committer']['date']
        masterDateMS = calendar.timegm(dateutil.parser.parse(masterDate).utctimetuple())
        dataID = self.record_data(masterDateMS, masterSHA, metaID, report_db)

        # finally, populate the source table with the metaID, dataID combo
        sourceID = self.record_source(metaID, dataID, report_db)

        # begin creating the stack for the rewinder with the master tuple
        stack = []
        stack.append((masterSHA, sourceID))

        # finish creating the stack for the rewinder with any tagged commits
        if len(tagJSON) > 0:
            # since files are deleted on rewind, it is important to order the tags by creation date
            tagTuples = []
            for tagObject in tagJSON:
                tagCommitJSON = self.get_json(tagObject['commit']['url'])
                tagCommitDate = tagCommitJSON['commit']['committer']['date']
                tagCommitDateMS = calendar.timegm(dateutil.parser.parse(tagCommitDate).utctimetuple())
                tagTuples.append((tagCommitDateMS, tagCommitJSON['sha']))

            # this should sort by tagCommitDateMS
            tagTuples.sort()

            # now add these tags to the report_db and the stack
            for tagTuple in tagTuples:
                dataID = self.record_data(tagTuple[0], tagTuple[1], metaID, report_db)
                sourceID = self.record_source(metaID, dataID, report_db)
                stack.append((tagTuple[1], sourceID))

        # shaSourceID tuples were appended from most recent backwards
        # reverse them to pop them quickly in that order
        stack.reverse()

        # empty the base folder, git clone the project, get rewindable path
        cloneURL = repoJSON['clone_url']
        sh.cd(path)
        sh.rm('-r', sh.glob('./*'))
        logging.info("GiPyS - geGiMaATaRe, cloning repository with url: " + cloneURL + " into path: " + path + " this may take some time...")
        sh.git.clone(cloneURL)
        os.chdir(path)
        repoDirName = os.walk('.').next()[1][0]
        rewindablePath = path + "/" + repoDirName
        logging.info("GiPyS - geGiMaATaRe, creating GitRewinder with repoID: " + str(repoID) + " with a stack of " + str(len(stack)) + " shas and a rewindable path: " + rewindablePath)
        return rewinder.GitRewinder(stack, rewindablePath, self.rewinder_type)

    # refresh the repos of projects, using the first page found
    # that has a python project on it
    # set exhausted to true if the source is exhausted
    # rationalle here is that getting a few pages and then
    # processing them spreads out api access so the limit
    # is likely to refresh before we run out
    def refresh_repos(self, lastRepo):
        self.log("refresh_repos, lastRepo: " + str(lastRepo))
        sinceLastJSON = self.get_json('https://api.github.com/repositories?since=' + str(lastRepo))
        if sinceLastJSON is None or sinceLastJSON == "":
            self.exhausted = True
            return
        repoID = "errorRepoID"
        projectCounter = 0
        for projectJSON in sinceLastJSON:
            repoID = projectJSON['id']
            try:
                languagesJSON = self.get_json(projectJSON['languages_url'])
                pythonProjectFound = "Python" in languagesJSON
                self.log("GiPyS - refresh_repos, projectFound:" + str(pythonProjectFound) + " languagesJSON: " + str(languagesJSON))
                if pythonProjectFound:
                    self.repos.append(projectJSON['id'])
            except:
                logging.warning("GiPyS - refresh_repos, failed to finish entire page of repos starting at lastRepo: " + str(lastRepo) + " but succeeded up to but excluding: " + str(repoID) + " which is the first " + str(projectCounter) + " projects.  this troublesome url will be skipped.")
            projectCounter += 1

        # repos can be empty if there are no python projects on this page
        if len(self.repos) == 0:
            logging.info("GiPyS - refresh_repos, no repos found on page starting at:" + str(lastRepo))
            self.refresh_repos(repoID)
        self.repos.reverse()
        logging.info("GiPyS - refresh_repos, finished refreshing, found " + str(len(self.repos)) + " Python repos in " + str(projectCounter) + " Github projects with last scanned repoID: " + str(repoID))

    # ############### database functions #################

    def initialize_report(self, report_db):
        self.log("initialize_report, report_db: " + report_db)
        # this report_db should already exist, created in Tourist
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("CREATE TABLE " + self.META_TABLE_NAME + " (repoID int, masterSHA text, repoJSON text, tagJSON text, masterJSON text)")
        c.execute("CREATE TABLE " + self.DATA_TABLE_NAME + " (commitDateTimeMS int, commitSHA text, metaID int)")
        conn.commit()
        conn.close()

    def record_meta(self, repoID, masterSHA, repoJSON, tagJSON, masterJSON, report_db):
        self.log("record_meta, repoID: " + str(repoID) + " masterSHA: " + masterSHA)
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO GithubMeta values (?,?,?,?,?)", (repoID, str(masterSHA), str(repoJSON), str(tagJSON), str(masterJSON)))
        metaRowID = c.lastrowid
        conn.commit()
        conn.close()
        return metaRowID

    def record_data(self, commitDateTimeMS, commitSHA, metaID, report_db):
        self.log("record_data, cDaTiMS: " + str(commitDateTimeMS) + " cSHA: " + commitSHA + " metaID: " + str(metaID))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO GithubData values (?,?,?)", (commitDateTimeMS, commitSHA, metaID))
        dataRowID = c.lastrowid
        conn.commit()
        conn.close()
        return dataRowID

    def record_source(self, metaID, dataID, report_db):
        self.log("record_source, metaID: " + str(metaID) + " dataID: " + str(dataID))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO Source values (?,?,?,?)", (self.META_TABLE_NAME, self.DATA_TABLE_NAME, metaID, dataID))
        sourceRowID = c.lastrowid
        conn.commit()
        conn.close()
        return sourceRowID
