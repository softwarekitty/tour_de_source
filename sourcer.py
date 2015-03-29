import time
import random
import sys
import factory
import util

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
        self.nextID = first - 1
        self.lastRepoID = self.nextID
        self.stop = stop

        self.nProjects = 0
        self.nRefreshRepoFailures = 0
        self.nGetRewinderFailures = 0
        self.exhausted = False
        self.repos = []
        self.logger.critical("initialized GithubPythonSourcer with rewinder_type: " + self.rewinder_type + " email: " + email + " first: " + str(first) + " stop:" + str(self.stop) + " credentials: " + str(self.credentials))

    def isExhausted(self):
        return bool(self.exhausted)

    # returns a rewinder for the next repo, or None if no more sources remain
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")

        # refresh the page if necessary, stop if necessary
        if not self.exhausted and len(self.repos) == 0:
            self.refresh_repos(self.lastRepoID)
            if len(self.repos) == 0:
                self.exhausted = True
        if self.exhausted is True:
            self.logger.critical("GiPyS - exhausted, since: " + str(self.nextID) + " stop: " + str(self.stop) + " len(repos): " + str(len(self.repos)))
            return None

        # repos is not empty, so make sure it is descending, then pop
        if self.repos[0] < self.repos[-1]:
            self.repos.reverse()
        self.nextID = self.repos.pop()

        # if we have gone beyond the stopping point, stop
        if self.nextID > self.stop:
            self.exhausted = True
            self.logger.critical("GiPyS - exhausted, since: " + str(self.nextID) + " stop: " + str(self.stop) + " len(repos): " + str(len(self.repos)))
            return None

        # if we are at the stopping point, then this is the last one
        if self.nextID == self.stop:
            self.exhausted = True
        self.logger.critical("GiPyS - next repoID: " + str(self.nextID))
        return self.getRewinder(self.nextID, repo_path, report_path, uniqueSourceID)

# ####################### convenience methods ################################

    # refresh the repos of projects, using the first page found
    # that has a python project on it
    # set exhausted to true if the source is exhausted
    # rationalle here is that getting a few pages and then
    # processing them spreads out api access so the limit
    # is likely to refresh before we run out
    def refresh_repos(self, lastRepo):
        self.log("refresh_repos, lastRepo: " + str(lastRepo))
        sinceLastJSON = util.get_json(self.logger, 'https://api.github.com/repositories?since=' + str(lastRepo), self.credentials, True)
        if sinceLastJSON is None or sinceLastJSON == "":
            self.exhausted = True
            return
        repoID = "errorRepoID"
        projectCounter = 0
        for projectJSON in sinceLastJSON:
            repoID = projectJSON['id']
            self.lastRepoID = repoID
            if repoID > self.stop:
                self.logger.info("GiPyS - refresh_repos, stopped refreshing with stop:" + str(self.stop) + " and current repoID: " + str(repoID))
                return
            try:
                languagesJSON = util.get_json(self.logger, projectJSON['languages_url'], self.credentials, True)
                pythonProjectFound = "Python" in languagesJSON
                self.logger.info("GiPyS - refresh_repos, repoID:" + str(repoID) + " hasPython: " + str(pythonProjectFound) + " name: " + projectJSON['name'])
                self.logger.debug("GiPyS - refresh_repos, since:" + str(self.nextID) + " len(repos): " + str(len(self.repos)) + " languagesJSON: " + str(languagesJSON))
                if pythonProjectFound:
                    self.repos.append(projectJSON['id'])
            except KeyboardInterrupt:
                raise
            except:
                self.logger.warning("GiPyS - refresh_repos, failed to finish entire page of repos starting at lastRepo: " + str(lastRepo) + " but succeeded up to but excluding: " + str(repoID) + " which is the first " + str(projectCounter) + " projects.  this troublesome url will be skipped.")
                self.nRefreshRepoFailures += 1
            projectCounter += 1
            self.nProjects += 1

        # repos can be empty if there are no python projects on this page
        if len(self.repos) == 0:
            self.logger.info("GiPyS - refresh_repos, no repos found on page starting at:" + str(lastRepo))
            self.refresh_repos(repoID)
            return
        self.logger.info("GiPyS - refresh_repos, finished refreshing, found " + str(len(self.repos)) + " Python repos in " + str(projectCounter) + " Github projects with last scanned repoID: " + str(repoID))

    def getNProjects(self):
        return self.nProjects

    def nRefreshRepoFailures(self):
        return self.nRefreshRepoFailures

    def nGetRewinderFailures(self):
        return self.nGetRewinderFailures

    def log(self, msg=""):
        self.logger.debug("GiPyS - " + msg + " since: " + str(self.nextID) + " len(repos): " + str(len(self.repos)))

    # error stream for `sh' instance
    def logErrorHandler(self, errorMessage):
        self.log("logErrorHandler, errorMessage: " + str(errorMessage))

    # this is a placeholder for adding rewinders to this sourcer
    def getRewinder(self, repoID, repo_path, report_path, uniqueSourceID):
        for i in range(0, 6):
            try:
                if self.rewinder_type == "20Commits":
                    return factory.nCommitsGithubRewinder(self.logger, repoID, repo_path, report_path, uniqueSourceID, 20, self.rewinder_type, self.credentials)
                elif self.rewinder_type == "mock":
                    return factory.getMockRewinder(self.logger, repoID, self.credentials)
                else:
                    return None
            except (KeyboardInterrupt, RuntimeWarning):
                raise
            except Exception as e:
                backoffS = random.randrange(min(2 ** i, 20))
                # this can happen when the dns gets in a bad state, or if a getRewinder method is throwing some exception
                self.logger.error("GiPySo-getRewinder, Issue creating rewinder for repoID: " + str(repoID) + ", iteration: " + str(i) + ", exception message: " + str(e))
                self.logger.critical("GiPySo-getRewinder, Backing off for " + str(backoffS) + " seconds")
                time.sleep(backoffS)

        # by returning None, we skip this source.
        self.logger.critical("GiPySo-getRewinder, Issue creating rewinder for repoID: " + str(repoID) + ", could not be resolved after 6 attempts.  Returning None.")
        self.nGetRewinderFailures += 1
        return None

# ############################# A Test Sourcer ############################


# this sourcer quickly simulates cloning a github repo by using a local folder
class LocalTestSourcer(GithubPythonSourcer):

    def __init__(self, rewinder_type, email, password, logger, credentials=None, first=1, stop=sys.maxsize, bp=None):
        logger.debug("LoTeSo - bp: " + str(bp))
        self.BASE_PATH = bp
        super(LocalTestSourcer, self).__init__(rewinder_type, email, password, logger, credentials, first, stop)

    # returns a rewinder for the next repo
    def next(self, repo_path, report_path, uniqueSourceID):
        self.log("next")
        self.nProjects = 1
        if self.exhausted is True:
            return None

        # only gets a rewinder once for the local test folder
        localFolderRewinder = factory.fakeNCommitsGithubRewinder(self.logger, self.nextID, repo_path, report_path, uniqueSourceID, 20, self.rewinder_type, self.BASE_PATH)
        self.exhausted = True
        return localFolderRewinder

    def log(self, msg=""):
        self.logger.debug("LoTeS - " + msg + " since: " + str(self.nextID) + " len(repos): " + str(len(self.repos)))
