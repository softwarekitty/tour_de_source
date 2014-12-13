import sqlite3
import astroid.manager
import astroid.as_string
import astroid.node_classes
import astroid.inspector
import logging
import util
import os
import re

'''
scanner interface is just 'scanDirectory(path, report_db)'
    path is a the directory path as a string
    report_db names the db file to report to

    but for the tourist's Scan table: (dateTimeMS int, nFiles int, sourceID int) to be meaningful, the scanner is expected to register at the start of each scan of one project version (getting a scanID) by writing to that table, and then all custom tables populated when scanning a project version should use reference that scanID.
'''


class PythonRegexScanner:
    id = "python regex scanner"
    pythonFilter = re.compile('.*\.py$', re.IGNORECASE)

    def log(self, msg=""):
        logging.debug("PyReS - " + msg)

    def scanDirectory(self, path, sourceID, report_db):
        self.log("scanDirectory, path: " + str(path) + " sourceID: " + str(sourceID) + " report_db: " + report_db)
        # c.execute('''CREATE TABLE name (Scan) (dateTimeMS int, nFiles int, sourceID int)''')
        # c.execute('''CREATE TABLE name (Source) (metaTablename text, dataTablename text, metaID int, dataID, int)''')

        allFiles = []
        for root, dirs, files in os.walk(path):
            for name in files:
                allFiles.append(os.path.join(root, name))
        pythonPaths = filter(self.pythonFilter.search, allFiles)

        # TODO - needs the sourceID, so sourcer needs implementation first
        scanID = self.register_scan(sourceID, len(pythonPaths), report_db)

        self.extract_regex(pythonPaths, scanID, report_db)

    # regex_flags = ["IGNORECASE","DEBUG","LOCALE","MULTILINE","DOTALL","UNICODE","VERBOSE"]

    # filePaths is a list of python file paths to scan
    def extract_regex(self, filePaths, scanID, report_db):
        self.log("extract_regex, len(filepaths): " + str(len(filePaths)) + " scanID: " + str(scanID))
        for filePath in filePaths:
            # print("parsing file: "+file)

            # hash to avoid re-scanning identical files.
            cuteHash = util.get_cuteHash(filePath)
            isUniqueHash = self.db_contains_hash(cuteHash, report_db)

            # the track_file function tracks duplicates, repeats
            fileID = self.track_file(cuteHash, filePath, scanID, report_db, isUniqueHash)
            if isUniqueHash:
                node = astroid.manager.AstroidManager().ast_from_file(filePath)
                self.extractRegexR(node, fileID, scanID, report_db)

    # this is public so that the index mapping is not mysterious
    def get_function_list(self):
        return ["re.compile", "re.search", "re.match", "re.split", "re.findall", "re.finditer", "re.sub", "re.subn"]

    def extractRegexR(self, child, fileID, scanID, report_db):
        # all the methods we will look for
        target_func = self.get_function_list()
        if isinstance(child, astroid.node_classes.CallFunc) and child.func.as_string() in target_func:
            regex_citation = [child.func.as_string(), "arg1", "arg2", "arg3", "arg4", "arg5"]
            arg_counter = 1
            for x in child.args:
                if isinstance(x, astroid.node_classes.Getattr):
                    key = x.attrname
                    gc = x.get_children().next().infer().next()

                    # for all the cases I've inspected,
                    # we see: x->Name->(Module() or _Yes or Class)
                    if isinstance(gc, astroid.scoped_nodes.Module):
                        regex_citation[arg_counter] = gc.globals[key][0].infer().next().as_string()
                    elif isinstance(gc, astroid.scoped_nodes.Class):
                        regex_citation[arg_counter] = gc.locals[key][0].infer().next().as_string()
                    elif isinstance(gc, astroid.bases._Yes):
                        neighborFile = x.get_children().next()
                        regex_citation[arg_counter] = str(neighborFile.name) + "." + str(x.attrname)
                    else:
                        logging.warning("PyReS - extractRegexR, unexpected class found: " + x.__class__.__name__)

                elif isinstance(x, astroid.node_classes.Name):
                    regex_citation[arg_counter] = x.infer().next().as_string()
                elif isinstance(x, astroid.node_classes.Const):
                    regex_citation[arg_counter] = x.as_string()
                else:
                    logging.warning("PyReS - extractRegexR, unexpected class found: " + x.__class__.__name__)
                arg_counter += 1
            regexFunction = target_func.index(regex_citation[0])
            pattern = regex_citation[1]
            flags = self.extract_flags(regexFunction, regex_citation)
            self.record_regex(scanID, fileID, regexFunction, pattern, flags, report_db)
        for grandchild in child.get_children():
            self.extractRegexR(grandchild, fileID, scanID, report_db)

    # this is the order in python docs and in our function list
    # re.compile(pattern,flags=0),
    # re.search(pattern,string,flags=0),
    # re.match(pattern,string,flags=0),
    # re.split(pattern,string,maxsplit=0,flags=0),
    # re.findall(pattern,string,flags=0),
    # re.finditer(pattern,string,flags=0),
    # re.sub(pattern,repl,string,count=0,flags=0),
    # re.subn(pattern,repl,string,count=0,flags=0),
    def extract_flags(self, regexFunction, regex_citation):
        if regexFunction == 0:
            return regex_citation[1]
        elif regexFunction in [1, 2, 4, 5]:
            return regex_citation[2]
        elif regexFunction == 3:
            return regex_citation[3]
        elif regexFunction in [6, 7]:
            return regex_citation[4]
        else:
            logging.error("PyReS - extract_flags, cannot extract flags from " + str(regex_citation))
            return 0

    def track_file(self, cuteHash, filePath, scanID, report_db, isUniqueHash):
        self.log("track_file, cuteHash: " + cuteHash + " filePath: " + filePath + " scanID: " + str(scanID))
        # fileID will be None if there is single no entry in the File table
        # with cuteHash, filepath, scanID all matching
        fileID = self.increment_tracked_file(cuteHash, filePath, scanID, report_db, isUniqueHash)
        if not fileID:
            return self.insert_file(cuteHash, filePath, scanID, 1, report_db)
        else:
            return fileID

    # ###################### database functions #######################

    def initialize_report(self, report_db):
        self.log("initialize_report, report_db: " + report_db)
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE Regex (scanID int, fileID int, regexFunction int, pattern text, flags int)''')
        c.execute('''CREATE TABLE File (cuteHash char(44), filePath text, scanID int, count int)''')
        conn.commit()
        conn.close()

    def record_regex(self, scanID, fileID, regexFunction, pattern, flags, report_db):
        self.log("record_regex, scanID: " + str(scanID) + " fileID: " + str(fileID) + " regexFunction: " + str(regexFunction) + " pattern: " + str(pattern) + " flags: " + str(flags))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO Regex values (?,?,?,?,?)", (scanID, fileID, regexFunction, pattern, flags))
        conn.commit()
        conn.close()

    def insert_file(self, cuteHash, filePath, scanID, count, report_db):
        self.log("insert_file, cuteHash: " + cuteHash + " scanID: " + str(scanID) + " count: " + str(count))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO File values (?,?,?,?)", (cuteHash, filePath, scanID, count))
        fileID = c.lastrowid
        conn.commit()
        conn.close()
        return fileID

    def increment_tracked_file(self, cuteHash, filePath, scanID, report_db, isUniqueHash):
        if isUniqueHash:
            return None
        else:
            conn = sqlite3.connect(report_db)
            c = conn.cursor()
            c.execute("SELECT * FROM File WHERE cuteHash=?, scanID=?, filePath=?", (cuteHash, scanID, filePath))
            found = c.fetchone()
            if found:
                fileID = c.lastrowid
                c.execute("UPDATE File SET count = count + 1 WHERE rowid =" + str(fileID))
            conn.commit()
            conn.close()
            if found:
                logging.info("PyReS - increment_tracked_file, cuteHash: " + cuteHash + " filePath: " + filePath + " scanID: " + str(scanID) + " fileID: " + str(fileID))
                return fileID
            else:
                return None

    def db_contains_hash(self, cuteHash, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("SELECT EXISTS(SELECT 1 FROM File WHERE cuteHash=? LIMIT 1)", (cuteHash))
        found = c.fetchone()
        conn.commit()
        conn.close()
        if found:
            return True
        else:
            return False
