import sqlite3
import rewinder


class GithubPythonSourcer:
    def __init__(self, rewinder_type):
        self.rewinder_type = rewinder_type

    def initialize_report(self, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE name (GithubMeta) (id int, repoID text, lastSHA text, lastRepoJSON text, lastTagJSON text)''')
        c.execute('''CREATE TABLE name (GithubData) (id int, commitDateTimeMS int, SHA text, metaID int)''')
        conn.commit()
        conn.close()

    def hasNext(self):
        return False

    def next(self):

        # later, make this return the right type of rewinder depending
        return rewinder.GitVersionRewinder()
