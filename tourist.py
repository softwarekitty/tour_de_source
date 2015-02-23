import sqlite3
import datetime
import util
import logging


class Tourist:

    def __init__(self, depot, email, scanner, sourcers):
        self.depot = depot
        self.email = email
        self.scanner = scanner
        self.sourcers = sourcers

        self.startS = util.getDateTimeS(datetime.datetime.utcnow())
        self.id = util.getUniqueCuteID(5, depot.getTourPath())
        self.report_db = 'R' + str(self.startS) + '_' + self.id + '.db'
        self.register()
        self.initialize_report()

        # because using the sh or os function can change the working directory, always access the database by a full path, not just the database name.
    def getReportPath(self):
        return self.depot.getDataPath() + self.report_db

    def register(self):
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        # id, startS, last, nFiles, status, scanner, email, download
        # note that scanner.id is a placeholder for the scanner blob
        insertStatement = 'INSERT INTO Tour VALUES ("' + self.id + '", ' + str(self.startS) + ', ' + str(self.startS) + ', 0, "INITIAL", "' + self.scanner.id + '", "' + self.email + '", "' + self.report_db + '")'
        logging.info("Touri - register, registering tourist in tour table with statement: " + insertStatement)
        c.execute(insertStatement)
        conn.commit()
        conn.close()

    def initialize_report(self):

        # initialize the core tables in the report
        conn = sqlite3.connect(self.getReportPath())
        c = conn.cursor()
        c.execute('''CREATE TABLE Scan (scanBeginS int, nFiles int, sourceID int)''')
        c.execute('''CREATE TABLE Source (metaTableName text, dataTableName text, metaID int, dataID int)''')
        conn.commit()
        conn.close()

        # now initialize whatever sourcer tables
        for s in self.sourcers:
            s.initialize_report(self.getReportPath())

        # finally, let the scanner create whatever tables it wants
        self.scanner.initialize_report(self.getReportPath())

    def tour(self):
        # main loop
        self.updateStatus("RUNNING")
        logging.info("Touri - tour, SCAN_" + self.id + " RUNNING")
        tour_complete = False
        consecutiveExceptionCounter = 0
        finalState = "FINISHED"
        while not tour_complete:
            sourcers_exhausted = True
            cancelled = False
            broken = False
            scanCount = 0
            for s in self.sourcers:
                if consecutiveExceptionCounter > 0:
                    logging.warning("Touri - tour, consecutiveExceptionCounter: " + str(consecutiveExceptionCounter))
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
                        sourcers_exhausted = False
                        r = s.next(self.depot.getRepoPath(), self.getReportPath())
                        logging.info("Touri - tour, SCAN_" + self.id + " now has rewinder: " + r.log())
                        while r.rewind():
                            self.scanner.scanDirectory(self.depot.getRepoPath(), r.getSourceID(), r.getMetaID, self.getReportPath())
                        consecutiveExceptionCounter = 0
                except Exception as e:
                    consecutiveExceptionCounter += 1
                    print str(e)
                    logging.error("Touri - tour, SCAN_" + self.id + " EXCEPTION:" + str(e))
                scanCount += 1
                logging.debug("Touri - tour, scanCount: " + str(scanCount))
            tour_complete = sourcers_exhausted or cancelled or broken
        self.updateStatus(finalState)
        logging.info("Touri - tour, SCAN_" + self.id + " FINAL STATE: " + finalState)

    def updateStatus(self, current_status):
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        c.execute('''UPDATE Tour SET status=? WHERE id=?''', (current_status, self.id, ))
        conn.commit()
        conn.close()

    def isCancelled(self):
        isCancelled = False
        conn = sqlite3.connect(self.depot.getTourPath())
        c = conn.cursor()
        c.execute('''SELECT status FROM Tour WHERE id=?''', (self.id, ))
        isCancelled = c.fetchone() == "CANCELLED"
        conn.close()
        logging.debug("Touri - tour, SCAN_" + self.id + " Tour Canceled: " + str(isCancelled))
        return isCancelled
