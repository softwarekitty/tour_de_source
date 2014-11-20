import sqlite3
import datetime
from util import getCuteID
from util import getDateTimeMS


class Tourist:
    REPORT_HEADER = "R_"
    REPORT_DELIM = "_"
    REPORT_TAIL = ".db"
    def __init__(self, tour_db, scanner):
        self.start = getDateTimeMS(datetime.datetime.utcnow())
        self.id = getCuteID(7)
        self.tour_db = tour_db
        self.report = REPORT_HEADER + self.id + REPORT_DELIM + self.start + REPORT_TAIL
        self.register(scanner)
        self.begin_report()

    def beginTour(self, scanner):
        pass

    def begin_report(self, scanner):
        conn = sqlite3.connect(self.report)
        c = conn.cursor()

        # TODO
        c.execute('''CREATE TABLE name (Tour) (id int, start int, last int, nFiles int, status text, scanner text, gmail text, download text)''')
        conn.commit()
        conn.close()



        conn = sqlite3.connect(self.tour_db)
        c = conn.cursor()
        # id, start, last, nFiles, status, scanner, email, download
        c.execute('''INSERT INTO Tour VALUES (''' + self.id + ''', 1100, 1200, 0, 'INITIAL', ''' + scanner.id + ''', 'contact and auth email', 'where to download product of tour')''')
        conn.commit()
        conn.close()

    def register(self, scanner):
        conn = sqlite3.connect(self.tour_db)
        c = conn.cursor()
        # id, start, last, nFiles, status, scanner, email, download
        c.execute('''INSERT INTO Tour VALUES (''' + self.id + ''', ''' + self.start + ''', 1200, 0, 'INITIAL', ''' + scanner.id + ''', 'contact and auth email', 'where to download product of tour')''')
        conn.commit()
        conn.close()

    def updateDepot(self, current_status):
        conn = sqlite3.connect(self.tour_db)
        c = conn.cursor()

        # TODO
        c.execute('''CREATE TABLE name (Tour) (id int, tour_start int, tour_last int, n_files int, status text, scanner text, gmail text, download_url text)''')
        conn.commit()
        conn.close()
