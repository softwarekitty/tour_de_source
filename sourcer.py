import sqlite3
import rewinder
import urllib2
import base64
import json
import re
import dateutil.parser
import calendar
import sh
import os

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
        self.last = 0
        self.repos = []

    def isExhausted(self):
        return bool(self.exhausted)

    # returns a rewinder for the next repo
    def next(self, path, report_db):
        if len(self.repos) == 0:
            self.refresh_repos(self.last)
        if self.exhausted is True:
            return None
        last = self.repos.pop()
        return self.getRewinder(last, path, report_db)

    def get_json(self, url):
        request = urllib2.Request(url)
        encoded64 = base64.encodestring("investigationBot:cro0thiezlutrl").replace('\n', '')
        request.add_header("Authorization", "Basic %s" % encoded64)
        return json.load(urllib2.urlopen(request))

    # this is a placeholder for adding rewinders to this sourcer
    def getRewinder(self, repoID, path, report_db):
        if self.rewinder_type == "MasterAndTags":
            return self.getGitMasterAndTagsRewinder(repoID, path, report_db)
        else:
            return None

    def getGitMasterAndTagsRewinder(self, repoID, path, report_db):

        # using repoID and github api, find masterSHA, repoJSON, tagJSON, masterJSON
        repoJSON = self.get_json("https://api.github.com/repositories/" + repoID)
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
                dataID = self.record_data(tagTuple[0], tagTuple[1], metaID)
                sourceID = self.record_source(metaID, dataID)
                stack.append(tagTuple[1], sourceID)

        # shaSourceID tuples were appended from most recent backwards
        # reverse them to pop them quickly in that order
        stack.reverse()

        # empty the base folder, git clone the project, get rewindable path
        sh.cd(self.path)
        sh.rm('-r', sh.glob('./*'))
        sh.git.clone(repoJSON['clone_url'])
        os.chdir(path)
        repoDirName = os.walk('.').next()[1][0]
        return rewinder.GitRewinder(stack, path + "/" + repoDirName, self.rewinder_type)

    # refresh the repos of projects, using the first page found
    # that has a python project on it
    # set exhausted to true if the source is exhausted
    # rationalle here is that getting a few pages and then
    # processing them spreads out api access so the limit
    # is likely to refresh before we run out
    def refresh_repos(self, lastRepo):
        sinceLastJSON = self.get_json('https://api.github.com/repositories?since=' + lastRepo)
        if sinceLastJSON is None or sinceLastJSON == "":
            self.exhausted = True
            return
        repoID = "errorRepoID"
        for projectJSON in sinceLastJSON:
            repoID = projectJSON['id']
            languagesJSON = self.get_json(projectJSON['languages_url'])
            if "Python" in languagesJSON:
                self.repos.append(repoID)

        # repos can be empty if there are no python projects on this page
        if len(self.repos) == 0:
            self.refresh_repos(repoID)
        self.repos.reverse()

    # ############### database functions #################

    def initialize_report(self, report_db):

        # this report_db should already exist, created in Tourist
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("CREATE TABLE " + self.META_TABLE_NAME + " (repoID text, masterSHA text, repoJSON text, tagJSON text, masterJSON)")
        c.execute("CREATE TABLE " + self.DATA_TABLE_NAME + " (commitDateTimeMS int, commitSHA text, metaID int)")
        conn.commit()
        conn.close()

    def record_meta(self, repoID, masterSHA, repoJSON, tagJSON, masterJSON, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO GithubMeta values (?,?,?,?,?)", (repoID, masterSHA, repoJSON, tagJSON, masterJSON))
        metaRowID = c.lastrowid
        conn.commit()
        conn.close()
        return metaRowID

    def record_data(self, commitDateTimeMS, commitSHA, metaID, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO GithubData values (?,?,?)", (commitDateTimeMS, commitSHA, metaID))
        dataRowID = c.lastrowid
        conn.commit()
        conn.close()
        return dataRowID

    def record_source(self, metaID, dataID, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO Source values (?,?,?,?)", (self.META_TABLE_NAME, self.DATA_TABLE_NAME, metaID, dataID))
        sourceRowID = c.lastrowid
        conn.commit()
        conn.close()
        return sourceRowID
