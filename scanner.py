import sqlite3


class PythonRegexScanner:
    id = "python regex scanner"

    def initialize_report(self, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE name (Regex) (id int, pattern text)''')
        c.execute('''CREATE TABLE name (RegexCitation) (id int, scanID int, fileID int, regexID int, row int, col int, lineCapture text, relativeFilePath text)''')
        c.execute('''CREATE TABLE name (File) (id int, size int, SHA256 text)''')
        conn.commit()
        conn.close()
