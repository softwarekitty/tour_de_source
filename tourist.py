import sqlite3
import datetime
import util


class Tourist(object):

    def __init__(self, depot, email, password, to, scanner, sourcers, logger):
        self.depot = depot
        self.email = email
        self.password = password
        self.to = to
        self.scanner = scanner
        self.sourcers = sourcers
        self.logger = logger

        self.startS = util.getDateTimeS(datetime.datetime.utcnow())
        self.id = util.getUniqueCuteID(5, depot.getTourPath())
        self.report_db = 'R' + str(self.startS) + '_' + self.id + '.db'
        self.register()
        self.scanner.initialize_report(self.getReportPath())

    def tour(self):
        # main loop
        self.updateStatus("RUNNING")
        self.logger.critical("Touri - tour, SCAN_" + self.id + " RUNNING")
        tour_complete = False
        consecutiveExceptionCounter = 0
        finalState = "FINISHED"
        uniqueSourceID = 0
        while not tour_complete:
            sourcers_exhausted = True
            cancelled = False
            broken = False
            for s in self.sourcers:
                if consecutiveExceptionCounter > 0:
                    self.logger.error("Touri - tour, consecutiveExceptionCounter: " + str(consecutiveExceptionCounter))
                if self.isCancelled():
                    cancelled = True
                    finalState = "CANCELLED"
                    break
                elif self.depot.getConsecutiveExceptionLimit() < consecutiveExceptionCounter:
                    broken = True
                    finalState = "BROKEN"
                    break
                try:
                    if not s.isExhausted():
                        r = s.next(self.depot.getRepoPath(), self.getReportPath(), uniqueSourceID)
                        if r:
                            sourcers_exhausted = False
                            uniqueSourceID += 1
                            shaSet = []
                            filePathSet = []
                            citationSet = []
                            self.logger.info("Touri - tour, SCAN_" + self.id + " now has rewinder: " + r.log())
                            while r.rewind():
                                self.scanner.scanDirectory(self.depot.getRepoPath(), self.getReportPath(), r.getUniqueSourceID(), r.getSourceJSON(), shaSet, filePathSet, citationSet)
                            self.logger.debug("filePathSet content: " + str(filePathSet))
                            self.logger.critical("Touri - scan complete for uniqueSourceID " + str(uniqueSourceID) + " len(filePathSet): " + str(len(filePathSet)) + " len(citationSet): " + str(len(citationSet)))
                            self.scanner.incrementFilesPerProject(len(filePathSet), self.getReportPath())
                            consecutiveExceptionCounter = 0
                except Exception as e:
                    consecutiveExceptionCounter += 1
                    print str(e)
                    self.logger.error("Touri - tour, SCAN_" + self.id + " EXCEPTION:" + str(e))
            tour_complete = sourcers_exhausted or cancelled or broken
        self.updateStatus(finalState)
        self.logger.critical("Touri - tour, SCAN_" + self.id + " FINAL STATE: " + finalState + " after scanning " + str(uniqueSourceID) + " sources containing Python out of " + str(s.getNProjects()) + " total sources observed")
        util.emailFinishedMessage(self.email, self.password, self.to, "TOUR COMPLETE!")


# ######################### conveneince methods #######################

    # because using the sh or os function can change the working directory, always access the database by a full path, not just the database name.
    def getReportPath(self):
        return self.depot.getDataPath() + self.report_db

    def register(self):
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        # id, startS, last, nFiles, status, scanner, email, download
        # note that scanner.id might be a placeholder for the scanner blob
        insertStatement = 'INSERT INTO Tour VALUES ("' + self.id + '", ' + str(self.startS) + ', ' + str(self.startS) + ', 0, "INITIAL", "' + self.scanner.id + '", "' + self.email + '", "' + self.report_db + '")'
        self.logger.info("Touri - register, registering tourist in tour table with statement: " + insertStatement)
        c.execute(insertStatement)
        conn.commit()
        conn.close()

    # convenience method for updating tour status in tour.db
    def updateStatus(self, current_status):
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        c.execute('''UPDATE Tour SET status=? WHERE id=?''', (current_status, self.id, ))
        conn.commit()
        conn.close()

    # this checks with tour.db to see if the tour has been cancelled
    def isCancelled(self):
        isCancelled = False
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        c.execute('''SELECT status FROM Tour WHERE id=?''', (self.id, ))
        isCancelled = c.fetchone() == "CANCELLED"
        conn.close()
        self.logger.critical("Touri - tour, SCAN_" + self.id + " Tour Canceled: " + str(isCancelled))
        return isCancelled


# useful for stress-testing the sourcer - no breaks!
class LookiLoo(Tourist):
    def __init__(self, depot, email, password, to, scanner, sourcers, logger):
        Tourist.__init__(self, depot, email, password, to, scanner, sourcers, logger)

    def tour(self):
        # main loop
        self.updateStatus("RUNNING")
        self.logger.critical("Looki - tour, SCAN_" + self.id + " RUNNING")
        tour_complete = False
        consecutiveExceptionCounter = 0
        finalState = "FINISHED"
        uniqueSourceID = 0
        while not tour_complete:
            sourcers_exhausted = True
            cancelled = False
            broken = False
            for s in self.sourcers:
                if consecutiveExceptionCounter > 0:
                    self.logger.error("Looki - tour, consecutiveExceptionCounter: " + str(consecutiveExceptionCounter))
                if self.isCancelled():
                    cancelled = True
                    finalState = "CANCELLED"
                    break
                elif self.depot.getConsecutiveExceptionLimit() < consecutiveExceptionCounter:
                    broken = True
                    finalState = "BROKEN"
                    break
                try:
                    if not s.isExhausted():
                        r = s.next(self.depot.getRepoPath(), self.getReportPath(), uniqueSourceID)
                        if r:
                            sourcers_exhausted = False
                            uniqueSourceID += 1
                            while r.rewind():
                                self.logger.info("Looki - just looking, not scanning")
                            consecutiveExceptionCounter = 0
                except Exception as e:
                    consecutiveExceptionCounter += 1
                    print str(e)
                    self.logger.error("Looki - tour, SCAN_" + self.id + " EXCEPTION:" + str(e))
            tour_complete = sourcers_exhausted or cancelled or broken
        self.updateStatus(finalState)
        self.logger.critical("Looki - tour, SCAN_" + self.id + " FINAL STATE: " + finalState + " after scanning " + str(uniqueSourceID) + " sources containing Python out of " + str(s.getNProjects()) + " total sources observed")
