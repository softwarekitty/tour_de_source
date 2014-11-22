import sqlite3
import datetime
import util
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
        conn = sqlite3.connect(self.tour_db)
        c = conn.cursor()
        # id, start, last, nFiles, status, scanner, email, download
        # note that scanner.id is a placeholder for the scanner blob
        c.execute('INSERT INTO Tour VALUES (' + self.id + ', ' + self.start + ', ' + self.start + ', 0, "INITIAL", ' + self.scanner.id + ', ' + self.email + ', ' + self.report_db + ')')
        conn.commit()
        conn.close()

    def initialize_report(self):
        # # always delete the report if it exists (we are restarting)
        # reportPath = self.depot.getPath() + self.report_db
        # try:
        #     os.remove(reportPath)
        # except OSError:
        #     pass

        # initialize the core tables
        conn = sqlite3.connect(self.report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE name (Scan) (ID int, dateTimeMS int, nFiles int, sourceID int)''')
        c.execute('''CREATE TABLE name (Source) (ID int, metaTablename text, dataTablename text, metaID int, dataID, int)''')
        conn.commit()
        conn.close()

        # now initialize whatever sourcer tables
        for s in self.sourcers:
            s.initialize_report(self.report_db)

        # finally, let the scanner create whatever tables it wants
        self.scanner.initialize_report(self.report_db)

    def beginTour(self):
        self.updateStatus("RUNNING")

        # main loop
        tour_complete = False
        while not tour_complete:
            sourcers_empty = True
            for s in self.sourcers:

                # get status from tour_db
                # if should stop(status)
                    # log reason, break
                # info = s.info
                # log info, status
                try:
                    if s.hasNext():
                        sourcers_empty = False
                        r = s.next()
                        while r.rewind():
                            self.scanner.scanDirectory(self.path, self.report_db)
                except Exception as e:
                    print "exception in main loop: ", e
                    self.updateStatus("ERROR")
            tour_complete = sourcers_empty
        self.updateStatus("FINISHED")

    def updateStatus(self, current_status):
        conn = sqlite3.connect(self.tour_db)
        c = conn.cursor()
        c.execute('''UPDATE Tour SET status=? WHERE id=?''', current_status, self.id)
        conn.commit()
        conn.close()
