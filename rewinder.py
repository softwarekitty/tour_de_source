import sh
import util
import logging

'''
    GitRewinder expects a list of (sha, sourceID) tuples with most recent on top, the path of the project in which the sha hashes can be used by git to rewind a project, and what type the rewinder is for logging (Version, MasterOnly, InitialOnly, 2Week, Monthly, etc.)
'''


class GitRewinder:

    def __init__(self, stack, path, type):
        self.stack = stack
        self.path = path
        self.type = type
        self.sourceID = -1
        self.sha = "initialized"
        self.cuteID = util.getCuteID(9)

    def rewind(self):
        self.log()
        if not self.stack:
            return False
        shaSourceIDTuple = self.stack.pop()
        self.sha = shaSourceIDTuple[0]
        self.sourceID = shaSourceIDTuple[1]

        # Note that --hard is needed to get rid of files from previous commits
        sh.cd(self.path)
        sh.git.reset("--hard", self.sha)
        return True

    def getType(self):
        return str(self.type)

    def getSourceID(self):
        return str(self.sourceID)

    def getSHA(self):
        return str(self.sha)

    def getID(self):
        return str(self.cuteID)

    def log(self):
        logging.debug("GitRe - type: " + self.getType() + " ID: " + self.getID() + " sha: " + self.getSHA() + " sourceID: " + self.getSourceID())
