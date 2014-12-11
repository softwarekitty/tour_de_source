import sqlite3
import datetime
import util
import logging
# import os


class Tourist:

    def __init__(self, depot, email, scanner, sourcers):
        self.depot = depot
        self.email = email
        self.scanner = scanner
        self.sourcers = sourcers

        self.start = util.getDateTimeMS(datetime.datetime.utcnow())
        self.id = util.getUniqueCuteID(5, depot.getDB())
        self.report_db = 'R' + self.id + '.db'
        self.register()
        self.initialize_report()

    def register(self):
        conn = sqlite3.connect(self.depot.getDB())
        c = conn.cursor()
        # id, start, last, nFiles, status, scanner, email, download
        # note that scanner.id is a placeholder for the scanner blob
        insertStatement = 'INSERT INTO Tour VALUES ("' + self.id + '", ' + str(self.start) + ', ' + str(self.start) + ', 0, "INITIAL", "' + self.scanner.id + '", "' + self.email + '", "' + self.report_db + '")'
        print "creating tour table with statement: " + insertStatement
        c.execute(insertStatement)
        conn.commit()
        conn.close()

    def initialize_report(self):

        # initialize the core tables
        conn = sqlite3.connect(self.report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE Scan (dateTimeMS int, nFiles int, sourceID int)''')
        c.execute('''CREATE TABLE Source (metaTableName text, dataTableName text, metaID int, dataID int)''')
        conn.commit()
        conn.close()

        # now initialize whatever sourcer tables
        for s in self.sourcers:
            s.initialize_report(self.report_db)

        # finally, let the scanner create whatever tables it wants
        self.scanner.initialize_report(self.report_db)

    def tour(self):
        # main loop
        self.updateStatus("RUNNING")
        logging.info("SCAN_" + self.id + " RUNNING")
        tour_complete = False
        consecutiveExceptionCounter = 0
        finalState = "FINISHED"
        while not tour_complete:
            sourcers_exhausted = True
            cancelled = False
            broken = False
            for s in self.sourcers:
                if self.isCancelled():
                    cancelled = True
                    finalState = "CANCELLED"
                    break
                elif self.depot.getConsecutiveExceptionLimit() > consecutiveExceptionCounter:
                    broken = True
                    finalState = "BROKEN"
                    break
                try:
                    if not s.isExhausted():
                        sourcers_exhausted = False
                        r = s.next(self.depot.getPath(), self.report_db)
                        logging.info("SCAN_" + self.id + ": " + r.log())
                        while r.rewind():
                            self.scanner.scanDirectory(self.depot.getPath(), r.getSourceID(), self.report_db)
                        consecutiveExceptionCounter = 0
                except Exception as e:
                    consecutiveExceptionCounter += 1
                    logging.exception("SCAN_" + self.id + " EXCEPTION:" + e)
            tour_complete = sourcers_exhausted or cancelled or broken
        self.updateStatus(finalState)
        logging.info("SCAN_" + self.id + " FINAL STATE: " + finalState)

    def updateStatus(self, current_status):
        conn = sqlite3.connect(self.depot.getDB())
        c = conn.cursor()
        c.execute('''UPDATE Tour SET status=? WHERE id=?''', (current_status, self.id, ))
        conn.commit()
        conn.close()

    def isCancelled(self):
        isCancelled = False
        conn = sqlite3.connect(self.depot.getDB())
        c = conn.cursor()
        c.execute('''SELECT status FROM Tour WHERE id=?''', (self.id, ))
        isCancelled = c.fetchone() == "CANCELLED"
        conn.close()
        return isCancelled
