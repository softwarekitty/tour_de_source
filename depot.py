import sqlite3
import os
import sh
import logging


class Depot:

    # if the tour.db file is not yet defined, or we are in recreate mode, create it
    def __init__(self):
        if self.shouldRenew():
            try:
                sh.cd(self.getDataPath())
                sh.rm('-r', sh.glob('./*.db'))
                logging.info("Depot - success trying to renew.")
            except:
                # expect to hit this when the db has not been created yet
                logging.info("Depot - failure trying to renew.")
                pass
        # not renewing, then you would create only if no db exists yet
        dbFilePath = self.getTourPath()
        if not os.path.isfile(dbFilePath):
            conn = sqlite3.connect(dbFilePath)
            c = conn.cursor()
            c.execute('''CREATE TABLE Tour (id text, start int, last int, nFiles int, status text, scanner text, gmail text, download text)''')
            conn.commit()
            conn.close()
            logging.info("Depot - __init__, new Tour table created in path: " + dbFilePath)
        else:
            logging.info("Depot - __init__, the file " + dbFilePath + " already exists and so no new Tour table has been created")

    # we don't want any accidental modification of this, so it's get only
    def getRepoPath(self):
        return '/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/repo/'

    def getDataPath(self):
        return '/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/data/'

    def getTourPath(self):
        return self.getDataPath() + 'tour.db'

    def shouldRenew(self):
        return True

    def getConsecutiveExceptionLimit(self):
        return 5


def test_depot():
    print "testing"
