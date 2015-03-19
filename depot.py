import sqlite3
import os
import sh
import util
from util import BASE_PATH


# the Depot is a placeholder for a program that tracks multiple simultaneous tours all using the interfaces provided by this project.  As of right now, it does not provide any useful functionality, but the idea is that multiple concurrent users would want separate repo paths, data paths, maybe exception limits, etc.  Any program managing many arbitrary program executions would want to know when they started, when they finished and where the generated report is.  The depot should handle these concerns, like how a depot might handle routing tourists, vehicles and luggage.
class Depot:

    # if the tour.db file is not yet defined, or we are in recreate mode, create it
    def __init__(self, logger):
        # signal the start of the outer depot program
        logger.critical("Depot - ***************init Depot**********.")
        if not os.path.exists(self.getRepoPath()):
            os.makedirs(self.getRepoPath())
        if not os.path.exists(self.getDataPath()):
            os.makedirs(self.getDataPath())
        if not os.path.exists(self.getDataPath()):
            os.makedirs(self.getDataPath() + "log/")
        if not os.path.exists(self.getDataPath() + "log/" + util.LOG_DEBUG_FILENAME):
            open(self.getDataPath() + "log/" + util.LOG_DEBUG_FILENAME, 'a').close()
        if not os.path.exists(self.getDataPath() + "log/" + util.LOG_CRITICAL_FILENAME):
            open(self.getDataPath() + "log/" + util.LOG_CRITICAL_FILENAME, 'a').close()

        # we should renew if we are in development mode - renewing erases old tour.db files.  If you don't renew, then we will append any new tours to the old tour.db file.
        if self.shouldRenew():
            try:
                sh.cd(self.getDataPath())
                sh.rm('-r', sh.glob('./*.db'))
                logger.info("Depot - success trying to renew.")
            except:
                # expect to hit this when the db has not been created yet
                logger.error("Depot - failure trying to renew.")
                pass

        # not renewing, then you would create only if no db exists yet
        dbFilePath = self.getTourPath()
        if not os.path.isfile(dbFilePath):
            conn = sqlite3.connect(dbFilePath)
            c = conn.cursor()

            # each tour gets an id, start and end time, number of files scanned so far, a status message, the type of scanner, email of submitter, and where the report can be downloaded.
            c.execute('''CREATE TABLE Tour (id text, start int, last int, nFiles int, status text, scannerType text, gmail text, reportPath text)''')
            conn.commit()
            conn.close()
            logger.info("Depot - __init__, new Tour table created in path: " + dbFilePath)
        else:
            logger.info("Depot - __init__, the file " + dbFilePath + " already exists and so no new Tour table has been created")


# ############################# immutable getters ###########################

    def getBasePath(self):
        return BASE_PATH

    # we don't want any accidental modification of this, so it's get only
    def getRepoPath(self):
        return self.getBasePath() + 'repo/'

    def getDataPath(self):
        return self.getBasePath() + 'data/'

    def getTourPath(self):
        return self.getDataPath() + 'tour.db'

    def shouldRenew(self):
        return True

    def getConsecutiveExceptionLimit(self):
        return 5
