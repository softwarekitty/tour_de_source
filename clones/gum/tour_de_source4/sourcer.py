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
import random
import sys
from util import BASE_PATH

'''*Sourcer interface:
        *Sourcer(rewinder_type, first, stop) rewinder_type could be Version, Weekly, 1%, initial, latest, etc - a placeholder for future extensions.  The first and stop variables allow control of the range of repoID values for this source to provide.  In accordance with the Github API, we will always be getting a page of repos with ID larger than a 'since' value.  So if 'first' is 201, we will query github with 'since' equal to 200, so that the lowest possible first repo is 200.  Similarly the 'stop' value will stop the sourcer from sourcing any values larger than 'stop', although it will source that repoID, if it exists.  No long running processes should occur in __init__.

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

    def __init__(self, rewinder_type, email, password, logger, credentials=None, first=1, stop=sys.maxsize):

        self.rewinder_type = rewinder_type
        if credentials is None:
            self.credentials = email[:email.index('@')] + ":" + password
        else:
            self.credentials = credentials
        self.logger = logger
        self.since = first - 1
        self.stop = stop

        self.nProjects = 0
        self.exhausted = False
        self.repos = []
        self.logger.critical("initialized GithubPythonSourcer with rewinder_type: " + self.rewinder_type + " email: " + email + " first: " + str(first) + " stop:" + str(self.stop))

    def isExhausted(self):
        return bool(self.exhausted)

    # returns a rewinder for the next repo, or None if no more sources remain
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")

        # refresh the page if necessary, stop if necessary
        if not self.exhausted and len(self.repos) == 0:
            self.refresh_repos(self.since)
            if len(self.repos) == 0:
                self.exhausted = True
        if self.exhausted is True:
            self.logger.critical("GiPyS - exhausted, since: " + str(self.since) + " stop: " + str(self.stop) + " len(repos): " + str(len(self.repos)))
            return None

        # repos is not empty, so pop
        self.since = self.repos.pop()

        # if we have gone beyond the stopping point, stop
        if self.since > self.stop:
            self.exhausted = True
            self.logger.critical("GiPyS - exhausted, since: " + str(self.since) + " stop: " + str(self.stop) + " len(repos): " + str(len(self.repos)))
            return None

        # if we are at the stopping point, then this is the last one
        if self.since == self.stop:
            self.exhausted = True
        self.logger.critical("GiPyS - next repoID: " + str(self.since))
        return self.getRewinder(self.since, repo_path, report_path, uniqueSourceID)

# ####################### convenience methods ################################

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
            if repoID > self.stop:
                self.logger.info("GiPyS - refresh_repos, stopped refreshing with stop:" + str(self.stop) + " and current repoID: " + str(repoID))
                return
            try:
                languagesJSON = self.get_json(projectJSON['languages_url'])
                pythonProjectFound = "Python" in languagesJSON
                self.logger.info("GiPyS - refresh_repos, repoID:" + str(repoID) + " hasPython: " + str(pythonProjectFound) + " name: " + projectJSON['name'])
                self.logger.debug("GiPyS - refresh_repos, since:" + str(self.since) + " len(repos): " + str(len(self.repos)) + " languagesJSON: " + str(languagesJSON))
                if pythonProjectFound:
                    self.repos.append(projectJSON['id'])
            except KeyboardInterrupt:
                raise
            except:
                self.logger.warning("GiPyS - refresh_repos, failed to finish entire page of repos starting at lastRepo: " + str(lastRepo) + " but succeeded up to but excluding: " + str(repoID) + " which is the first " + str(projectCounter) + " projects.  this troublesome url will be skipped.")
            projectCounter += 1
            self.nProjects += 1

        # repos can be empty if there are no python projects on this page
        if len(self.repos) == 0:
            self.logger.info("GiPyS - refresh_repos, no repos found on page starting at:" + str(lastRepo))
            self.refresh_repos(repoID)
            return
        self.repos.reverse()
        self.logger.info("GiPyS - refresh_repos, finished refreshing, found " + str(len(self.repos)) + " Python repos in " + str(projectCounter) + " Github projects with last scanned repoID: " + str(repoID))

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
                if limit_remaining % 10 == 0:
                    self.logger.info("GiPyS - limit_remaining: " + str(limit_remaining))

                # don't push the rate limit if none remain - wait for reset
                if limit_remaining <= 1:
                    limit_resetS = rateJSON['resources']['core']['reset']
                    nowS = calendar.timegm(time.gmtime())
                    time_to_waitS = limit_resetS - (nowS - 2)
                    self.logger.critical("GiPyS - get_json, blocked by rate limit: " + str(limit_remaining) + " ttwS: " + str(time_to_waitS))
                    time.sleep(time_to_waitS)

                urlJSON = json.load(urllib2.urlopen(self.get_authorized_request(url)))
                self.logger.debug("GiPyS - get_json Success, url: " + url + " limit_remaining: " + str(limit_remaining))
                return urlJSON
            except urllib2.HTTPError, e:
                self.logger.error("GiPyS - get_json, HTTPError!!!")
            except Exception as e:
                self.logger.critical("GiPyS - get_json, Unexpected roblem with getting json: " + str(e))

            # break out of this cycle for troublesome urls
            attempt_counter += 1
            if attempt_counter >= attempt_limit:
                self.logger.critical("GiPyS - get_json, Giving up on url " + url + " after " + str(attempt_counter) + " attempts")
                raise Exception("this url is not worth the trouble: " + url)

            # back off a random time to avoid looking like such a robot
            backoffS = random.randrange(emergency_waitS)
            self.logger.warning("GiPyS - get_json, backing off with backoffS: " + str(backoffS) + " attempt: " + str(attempt_counter) + "/" + str(attempt_limit) + " url: " + url)
            time.sleep(backoffS)

    def getNProjects(self):
        return self.nProjects

    def get_authorized_request(self, url):
        encoded64 = base64.encodestring(self.credentials).replace('\n', '')
        request = urllib2.Request(url)
        request.add_header("Authorization", "Basic %s" % encoded64)
        return request

    def log(self, msg=""):
        self.logger.debug("GiPyS - " + msg + " since: " + str(self.since) + " len(repos): " + str(len(self.repos)))

    # error stream for `sh' instance
    def logErrorHandler(self, errorMessage):
        self.log("logErrorHandler, errorMessage: " + str(errorMessage))

    # this is a placeholder for adding rewinders to this sourcer
    def getRewinder(self, repoID, repo_path, report_path, uniqueSourceID):
        for i in range(0, 10):
            try:
                if self.rewinder_type == "MasterAndTags":
                    return self.getGitMasterAndTagsRewinder(repoID, repo_path, report_path, uniqueSourceID)
                elif self.rewinder_type == "20Commits":
                    return self.nCommitsGithubRewinder(repoID, repo_path, report_path, uniqueSourceID, 20)
                elif self.rewinder_type == "mock":
                    return self.getMockRewinder(repoID)
                else:
                    return None
            except KeyboardInterrupt:
                raise
            except Exception as e:
                backoffS = random.randrange(min(2 ** i, 40))
                # this can happen when the dns gets in a bad state, or if a getRewinder method is throwing some exception
                self.logger.error("GiPySo-getRewinder, Issue creating rewinder for repoID: " + str(repoID) + ", iteration: " + str(i) + ", exception message: " + str(e))
                self.logger.critical("GiPySo-getRewinder, Backing off for " + str(backoffS) + " seconds")
                time.sleep(backoffS)

        # by returning None, we skip this source.
        self.logger.critical("GiPySo-getRewinder, Issue creating rewinder for repoID: " + str(repoID) + ", could not be resolved after 10 attempts.  Returning None.")
        return None

# these rewinders are so large that they could be in their own file
# ############################ NCommits ###############################

        # Rewinder ready to rewind.
        # This rewinder will bookmark up to `n' commits on the master branch, about evenly spaced and in the same descending order as returned by git log.  The list should include the most recent commit first.
    def nCommitsGithubRewinder(self, repoID, repo_path, report_path, uniqueSourceID, n):

        # get metadata for sourceJSON
        repoJSON = self.get_json("https://api.github.com/repositories/" + str(repoID))
        repo_name = repoJSON['name']
        default_branch = repoJSON['default_branch']
        self.log("nCoGiRe - default branch name: " + default_branch)
        clone_url = repoJSON['clone_url']

        # erase everything in repo_path and then clone project
        sh.cd(repo_path)
        sh.rm('-r', sh.glob('./*'), _err=self.logErrorHandler)
        self.logger.warning("GiPyS - nCoGiRe, cloning repository with url: " + clone_url + " into path: " + repo_path + " this may take some time...")
        sh.git.clone(clone_url, "-b", default_branch)

        # hopefully the correct directory has the same name as the project, or is the last directory of all cloned directories.  This can vary - with git you could potentially have all your files in the root cloned directory, but in practice, almost noone does that.  I have seen several projects with multiple folders in this root cloned directory.  I think this is a case where it is best to just ignore the unusual ones.
        directoriesInPath = os.listdir(repo_path)
        directoriesInPath.sort()
        for directory in directoriesInPath:
            if not directory[0] == ".":
                if directory.lower() == repo_name.lower():
                    repoDirName = directory
                    break
                repoDirName = directory

        if repoDirName != repo_name:
            self.logger.critical("GiPyS - nCoGiRe, did not find folder with same name as project(" + repo_name + ").  Using the last directory found: " + repoDirName)

        # now get the time and sha for commits
        sh.cd(repoDirName)
        commitList = []
        for line in sh.git.log("--format=format:\"%ct %H\"", _iter=True, _tty_out=False, _err=self.logErrorHandler):
            cleanedLine = line[line.find('"') + 1:line.rfind('"')]
            pair = cleanedLine.split(' ')

            # this json is what couples each rewinded data source to a particular github project version.  For bitbucket or another source, many of the inner fields should be different, but the three root fields: type, meta and data should be the same for all future sourceJson objects like this.
            sourceJson = json.dumps({"type": "Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repoDirName}, "data": {"sha": str(pair[1]), "commitS": str(pair[0])}})
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

# ############################ fakeNCommits ###############################

        # For testing
    def fakeNCommitsGithubRewinder(self, repoID, repo_path, report_path, uniqueSourceID, n):
        default_branch = "master"
        clone_url = "fake_clone_url"
        repo_name = "copycat"

        self.log("nCoGiRe, rsync-ing test_repo folder to repo folder")
        sh.rsync("-r", BASE_PATH + 'test_repo/', repo_path,)
        sh.cd(repo_path)

        # hopefully the correct directory has the same name as the project, or is the last directory of all cloned directories.  This can vary - with git you could potentially have all your files in the root cloned directory, but in practice, almost noone does that.  I have seen several projects with multiple folders in this root cloned directory.  I think this is a case where it is best to just ignore the unusual ones.
        directoriesInPath = os.listdir(repo_path)
        directoriesInPath.sort()
        for directory in directoriesInPath:
            if not directory[0] == ".":
                if directory.lower() == repo_name.lower():
                    repoDirName = directory
                    break
                repoDirName = directory

        if repoDirName != repo_name:
            self.logger.critical("GiPyS - nCoGiRe, did not find folder with same name as project(" + repo_name + ").  Using the last directory found: " + repoDirName)

        # now get the time and sha for commits
        sh.cd(repoDirName)
        commitList = []
        for line in sh.git.log("--format=format:\"%ct %H\"", _iter=True, _tty_out=False, _err=self.logErrorHandler):
            cleanedLine = line[line.find('"') + 1:line.rfind('"')]
            pair = cleanedLine.split(' ')

            # this json is what couples each rewinded data source to a particular github project version.  For bitbucket or another source, many of the inner fields should be different, but the three root fields: type, meta and data should be the same for all future sourceJson objects like this.
            sourceJson = json.dumps({"type": "Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repoDirName}, "data": {"sha": str(pair[1]), "commitS": str(pair[0])}})
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

# ############################ MasterAndTags ##########################

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
        self.logger.info("GiPyS - geGiMaATaRe, cloning repository with url: " + cloneURL + " into path: " + repo_path + " this may take some time...")
        # this used to work, now I'm using:
        # sh.git.clone(clone_url, "-b", default_branch) with clone_url=repoJSON['clone_url']

        sh.git.clone(cloneURL)

        # TODO - less hackish way to find the new cloned directory.
        # here the invisible '.DS_Store' directory is sometimes present
        directoriesInPath = os.listdir(repo_path)
        directoriesInPath.sort()
        if len(directoriesInPath) == 1:
            repoDirName = directoriesInPath[0]
        else:
            repoDirName = directoriesInPath[1]

        self.logger.debug("GiPyS - geGiMaATaRe, repoDirName: " + repoDirName)
        rewindablePath = repo_path + repoDirName
        self.logger.info("GiPyS - geGiMaATaRe, creating GitRewinder with repoID: " + str(repoID) + " with a stack of " + str(len(stack)) + " shas and a rewindable path: " + rewindablePath)
        return rewinder.GitRewinder(stack, rewindablePath, metaID, self.rewinder_type)

# this is for testing the github api, so we want many calls to get_json
# ############################# OnlyJSON ############################
    def getMockRewinder(self, repoID):
        self.log("getMock, repoID: " + str(repoID) + " maxing out calls to github.")
        for i in range(0, 1000):
            repoJSON = self.get_json("https://api.github.com/repositories/" + str(repoID))
            repo_name = repoJSON['name']
        default_branch = repoJSON['default_branch']
        self.log("getMock - default branch name: " + default_branch)
        clone_url = repoJSON['clone_url']
        masterURL = re.sub(r'({.*)$', '/' + default_branch, repoJSON['branches_url'])
        masterJSON = self.get_json(masterURL)
        masterSHA = masterJSON['commit']['sha']
        masterDate = masterJSON['commit']['commit']['committer']['date']
        masterDateS = calendar.timegm(dateutil.parser.parse(masterDate).utctimetuple())
        sourceJSON = json.dumps({"type": "Mock_Github", "meta": {"repoID": str(repoID), "default_branch": str(default_branch), "clone_url": clone_url, "name": repo_name}, "data": {"sha": masterSHA, "commitS": masterDateS}})
        return rewinder.MockRewinder(repoID, sourceJSON)

# ############################# A Test Sourcer ############################


# this sourcer quickly simulates cloning a github repo by using a local folder
class LocalTestSourcer(GithubPythonSourcer):

    # returns a rewinder for the next repo
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")
        self.nProjects = 1
        if self.exhausted is True:
            return None

        # only gets a rewinder once for the local test folder
        localFolderRewinder = self.fakeNCommitsGithubRewinder(self.since, repo_path, report_path, uniqueSourceID, 20)
        self.exhausted = True
        return localFolderRewinder

    def log(self, msg=""):
        self.logger.debug("LoTeS - " + msg + " since: " + str(self.since) + " len(repos): " + str(len(self.repos)))
