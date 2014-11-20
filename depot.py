import sqlite3


def initializeTourDatabase(self, db_name):
    conn = sqlite3.connect(db_name)
    c = conn.cursor()
    c.execute('''CREATE TABLE name (Tour) (id int, start int, last int, nFiles int, status text, scanner text, gmail text, download text)''')
    conn.commit()
    conn.close()


class Depot:
    DB = 'tour.db'
    initializeTourDatabase(DB)
