import sh
import util

'''
    GitRewinder expects a list of (sha, sourceID) tuples with most recent on top, the path of the project in which the sha hashes can be used by git to rewind a project, and what type the rewinder is for logging (Version, MasterOnly, InitialOnly, 2Week, Monthly, etc.)
'''


# notice in this class there is no database access or logging done directly, only enough code to accomplish the effect of rewinding the source
class GitRewinder:

    def __init__(self, stack, path, type):
        self.stack = stack
        self.path = path
        self.type = type
        self.sourceID = -1
        self.sha = "initialized"
        self.cuteID = util.getCuteID(9)

    def rewind(self):
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
        return self.type

    def getSourceID(self):
        return self.sourceID

    def getSHA(self):
        return self.sha

    def getID(self):
        return self.cuteID

    def log(self):
        return "GitRe - log, type: " + self.getType() + " ID: " + self.getID() + " sha: " + self.getSHA() + " sourceID: " + str(self.getSourceID())
