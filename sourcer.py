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
        *Sourcer(rewinder_type) rewinder_type could be Version, Weekly, 1%, first, last, etc - a placeholder for future extensions.  No long running processes should occur in __init__.

        isExhausted()
            false if the sourcer has more sources of scannable folders

        next()
            provides a rewinder for the next source.  See rewinder interface.
'''

'''Note about using lists as a stack:
    pop() is O(1), append() is O(1), reverse() is O(n), pop(0) is O(n).
    For logical consistency, I want next() to always get the next larger repoID.  And when used in rewinders, I want rewind() to start at the most recent commit and go backwards.  When building both of these lists the items appear in that order and I append as I go through them and then reverse the list after everything is added, because python lists pop at the tail.  We could follow the FIFO of a queue and pop(0) without reversing, but that technique would be O(n^2), whereas this technique is O(n), although it probably doesn't matter much.
'''


class GithubPythonSourcer(object):

    def __init__(self, rewinder_type):
        self.rewinder_type = rewinder_type
        self.exhausted = False
        self.last = 0
        # self.last = 15249308 - this makes the first Python project very small
        self.repos = []
        self.log("initialized")

    def isExhausted(self):
        return bool(self.exhausted)

    # returns a rewinder for the next repo
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")
        if len(self.repos) == 0:
            self.refresh_repos(self.last)
        if self.exhausted is True:
            return None
        self.last = self.repos.pop()
        return self.getRewinder(self.last, repo_path, report_path, uniqueSourceID)

# ####################### convenience methods ################################

    def log(self, msg=""):
        logMessage = "GiPyS - " + msg + " last: " + str(self.last) + " len(repos): " + str(len(self.repos))
        if self.exhausted:
            logMessage = logMessage + " exhausted:True"
            logging.warning(logMessage)
        else:
            logging.debug(logMessage)

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
                self.log("refresh_repos, projectFound:" + str(pythonProjectFound) + " languagesJSON: " + str(languagesJSON))
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
    def getRewinder(self, repoID, repo_path, report_path, uniqueSourceID):
        if self.rewinder_type == "MasterAndTags":
            return self.getGitMasterAndTagsRewinder(repoID, repo_path, report_path, uniqueSourceID)
        elif self.rewinder_type == "20Commits":
            return self.nCommitsGithubRewinder(self, repoID, repo_path, report_path, uniqueSourceID, 20)
        else:
            return None

        # Rewinder ready to rewind.
        # This rewinder will bookmark up to `n' commits on the master branch, about evenly spaced and in the same descending order as returned by git log.  The list should include the most recent commit first.
    def nCommitsGithubRewinder(self, repoID, repo_path, report_path, uniqueSourceID, n):

        # this will need to be gotten from github, faked here for testing:
        default_branch = "master"
        clone_url = "fake_clone_url"

        self.log("nCoGiRe, rsync-ing test_repo folder to repo folder")
        sh.rsync("-r", '/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/test_repo/', repo_path,)
        sh.cd(repo_path)
        directoriesInPath = os.listdir(repo_path)
        directoriesInPath.sort()

        # TODO - find the right directory more often
        for directory in directoriesInPath:
            if not directory[0] == ".":
                repoDirName = directory

        # now get the time and sha for commits
        sh.cd(repoDirName)
        commitList = []
        for line in sh.git.log("--format=format:\"%ct %H\"", _iter=True, _tty_out=False, _err=self.logErrorHandler):
            cleanedLine = line[line.find('"') + 1:line.rfind('"')]
            pair = cleanedLine.split(' ')

            # this json is what couples each rewinded data source to a particular github project version.  For bitbucket or another source, many of the inner fields should be different, but the three root fields: type, meta and data should be the same for all future sourceJson objects like this.
            sourceJson = json.dumps({"type": "Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url}, "data": {"sha": str(pair[1]), "commitS": str(pair[0])}})
            if len(pair) == 2:
                commitList.append((pair[0], pair[1], sourceJson))

        # here we are sorting by the first field of the tuple: the commit time
        commitList.sort(reverse=True)
        nCommits = len(commitList)
        rewindablePath = repo_path + repoDirName

        if nCommits <= n:
            # return a rewinder with all commits
            stack = commitList
        else:
            # return a rewinder with n commits, spaced out about evenly
            unitFloat = nCommits / float(n - 1)
            stack = []

            # always put the most recent first
            stack.append(commitList[0])

            # put the rest
            for multiplier in range(1, n):
                commitIndex = int(multiplier * unitFloat) - 1
                stack.append(commitList[commitIndex])

        # remember python lists pop at the tail...
        stack.reverse()
        return rewinder.GitRewinder(rewindablePath, self.rewinder_type, uniqueSourceID, stack)


        # Rewinder ready to rewind.  populates the meta, data, source tables, clones repo and builds stack for Rewinder.
    def getGitMasterAndTagsRewinder(self, repoID, repo_path, report_path):
        self.log("geGiMaATaRe, repoID: " + str(repoID))
        # TODO - this code is out of synch with version 4 (with the nCommitsGithubRewinder).  It was probably a bad assumption to think that the wide variety of people using Github all have similar behavior with the rather unpopular tagging feature.  In fact a huge number of projects don't have any tags, and when they are used, they might be used for major version releases (as I expected) or for things like the major build every two weeks, or just as an experiment by people who haven't figured out how they want to use tags.

        # using repoID and github api, find masterSHA, repoJSON, tagJSON, masterJSON
        repoJSON = self.get_json("https://api.github.com/repositories/" + str(repoID))
        default_branch = repoJSON['default_branch']
        tagJSON = self.get_json(repoJSON['tags_url'])
        masterURL = re.sub(r'({.*)$', '/' + default_branch, repoJSON['branches_url'])
        masterJSON = self.get_json(masterURL)
        masterSHA = masterJSON['commit']['sha']

        # populate the meta table with this project's meta information
        metaID = self.record_meta(repoID, masterSHA, repoJSON, tagJSON, masterJSON, report_path)

        # populate the data table with masterDateS, masterSHA, metaID
        masterDate = masterJSON['commit']['commit']['committer']['date']
        masterDateS = calendar.timegm(dateutil.parser.parse(masterDate).utctimetuple())
        dataID = self.record_data(masterDateS, masterSHA, metaID, report_path)

        # finally, populate the source table with the metaID, dataID combo
        sourceID = self.record_source(metaID, dataID, report_path)

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
                tagCommitDateS = calendar.timegm(dateutil.parser.parse(tagCommitDate).utctimetuple())
                tagTuples.append((tagCommitDateS, tagCommitJSON['sha']))

            # this should sort by tagCommitDateS
            tagTuples.sort()

            # now add these tags to the report_db and the stack
            for tagTuple in tagTuples:
                dataID = self.record_data(tagTuple[0], tagTuple[1], metaID, report_path)
                sourceID = self.record_source(metaID, dataID, report_path)
                stack.append((tagTuple[1], sourceID))

        # shaSourceID tuples were appended from most recent backwards
        # reverse them to pop them quickly in that order
        stack.reverse()

        # empty the base folder, git clone the project, get rewindable path
        cloneURL = repoJSON['clone_url'] + " -b " + default_branch
        sh.cd(repo_path)
        sh.rm('-r', sh.glob('./*'), _err=self.logErrorHandler)
        logging.info("GiPyS - geGiMaATaRe, cloning repository with url: " + cloneURL + " into path: " + repo_path + " this may take some time...")
        sh.git.clone(cloneURL)

        # TODO - less hackish way to find the new cloned directory.
        # here the invisible '.DS_Store' directory is sometimes present
        directoriesInPath = os.listdir(repo_path)
        directoriesInPath.sort()
        if len(directoriesInPath) == 1:
            repoDirName = directoriesInPath[0]
        else:
            repoDirName = directoriesInPath[1]

        logging.debug("GiPyS - geGiMaATaRe, repoDirName: " + repoDirName)
        rewindablePath = repo_path + repoDirName
        logging.info("GiPyS - geGiMaATaRe, creating GitRewinder with repoID: " + str(repoID) + " with a stack of " + str(len(stack)) + " shas and a rewindable path: " + rewindablePath)
        return rewinder.GitRewinder(stack, rewindablePath, metaID, self.rewinder_type)

    # error stream for `sh' instance
    def logErrorHandler(self, errorMessage):
        self.log("logErrorHandler, errorMessage: " + str(errorMessage))

# ############################# A Test Sourcer ############################


# this sourcer quickly simulates cloning a github repo by using a local folder
class LocalTestSourcer(GithubPythonSourcer):

    # returns a rewinder for the next repo
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")
        if self.exhausted is True:
            return None

        # only gets a rewinder once for the local test folder
        localFolderRewinder = self.getRewinder(self.last, repo_path, report_path, uniqueSourceID)
        self.exhausted = True
        return localFolderRewinder

# ####################### convenience methods ##############################

    def log(self, msg=""):
        logMessage = "LoTeS - " + msg + " last: " + str(self.last) + " len(repos): " + str(len(self.repos))
        if self.exhausted:
            logMessage = logMessage + " exhausted:True"
            logging.warning(logMessage)
        else:
            logging.debug(logMessage)

    # this is a placeholder for adding rewinders to this sourcer
    # for the test sourcer, we always use the same rewinder
    def getRewinder(self, repoID, repo_path, report_path, uniqueSourceID):
        return self.nCommitsGithubRewinder(repoID, repo_path, report_path, uniqueSourceID, 20)
