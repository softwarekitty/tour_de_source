import sqlite3
import astroid.manager
import astroid.as_string
import astroid.node_classes
import astroid.inspector
import datetime
import logging
import util
import os
import re

'''
scanner interface is: 'scanDirectory(repoPath, reportPath, UniqueSourceID, sourceJSON)'
    repoPath is a the directory where the repo to scan exists
    reportPath is where sqlite can open a connection to the report DB
    UniqueSourceID is unique across all sourcers to this project source
    sourceJSON holds whatever information the sourcer provides to clarify the type, meta and data information about the source - like it was Github, ropID 15341, master branch, clone_url..., sha 2344833 committed at time 14393383838.  These details can depend on what is useful, and are likely to evolve a bit over time.
'''


class PythonRegexScanner:
    id = "python regex scanner"
    pythonFilter = re.compile('.*\.py$', re.IGNORECASE)

    def scanDirectory(self, path, report_db, uniqueSourceID, sourceJSON, shaSet):
        scanBeginS = util.getDateTimeS(datetime.datetime.utcnow())
        logging.debug("PyReS - scanDirectory, path: " + str(path) + " uniqueSourceID: " + str(uniqueSourceID) + " scanBeginS: " + str(scanBeginS) + " report_db: " + report_db)

        # get a list of the python file paths
        allFiles = []
        for root, dirs, files in os.walk(path):
            for name in files:
                allFiles.append(os.path.join(root, name))
        pythonPaths = filter(self.pythonFilter.search, allFiles)
        nDuplicates = 0
        progressCounter = 0

        for pythonFilePath in pythonPaths:
            try:
                fileHash = util.get_cuteHash(pythonFilePath)
                if fileHash not in shaSet:
                    progressCounter = 0
                    shaSet.append(fileHash)
                    node = astroid.manager.AstroidManager().ast_from_file(pythonFilePath)
                    progressCounter = 1
                    patternSet = []
                    cleanFilePath = pythonFilePath[len(path):]
                    self.extractRegexR(node, report_db, patternSet, uniqueSourceID, sourceJSON, fileHash, cleanFilePath)
                    progressCounter = 2
                    self.incrementPatternsPerFile(len(patternSet), report_db)
                else:
                    nDuplicates += 1
            except Exception as e:
                logging.warning("PyReS - problem extracting from file: " + str(pythonFilePath) + " exception: " + str(e) + " progressCounter: " + str(progressCounter))
        logging.info("PyReS - finished scanning directory: " + str(path) + " nDuplicates: " + str(nDuplicates))

    # regex_flags = ["IGNORECASE","DEBUG","LOCALE","MULTILINE","DOTALL","UNICODE","VERBOSE"]
    def extractRegexR(self, child, report_db, patternSet, uniqueSourceID, sourceJSON, fileHash, pythonFilePath):
        # all the methods we will look for
        target_func = self.get_function_list()
        if isinstance(child, astroid.node_classes.CallFunc) and child.func.as_string() in target_func:
            # self.log("found targedFunction: " + str(child.func.as_string()))
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
            if pattern not in patternSet:
                patternSet.append(pattern)
            flags = self.extract_flags(regexFunction, regex_citation)
            self.record_regex_citation(uniqueSourceID, sourceJSON, fileHash, pythonFilePath, pattern, flags, regexFunction, report_db)
        for grandchild in child.get_children():
            self.extractRegexR(grandchild, report_db, patternSet, uniqueSourceID, sourceJSON, fileHash, pythonFilePath)

    # ###################### database functions #######################

    def initialize_report(self, report_db):
        logging.info("PyReS - initialize_report, report_db: " + report_db)
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE RegexCitation (uniqueSourceID int, sourceJSON text, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)''')
        c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')
        c.execute('''CREATE TABLE PatternsPerFile (nPatterns int, frequency int)''')
        conn.commit()
        conn.close()

        # the Coalesce function returns the first non-null option.
    def incrementPatternsPerFile(self, numberOfPatterns, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''SELECT frequency FROM PatternsPerFile WHERE nPatterns = ?''', (numberOfPatterns,))

        # oldFrequency will be a tuple like (1,) or null
        oldFrequency = c.fetchone()
        # self.log("oldFrequency: " + str(oldFrequency) + " not oldFrequency: " + str(not oldFrequency))
        if not oldFrequency:
            c.execute("INSERT INTO PatternsPerFile values (?,?)", (numberOfPatterns, 1))
        else:
            c.execute("UPDATE PatternsPerFile SET frequency=? WHERE nPatterns=?", (oldFrequency[0] + 1, numberOfPatterns))
        conn.commit()
        conn.close()

    def incrementFilesPerProject(self, numberOfFiles, report_db):
        logging.debug("PyReS - incrementing filesPerProject: " + str(numberOfFiles))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''SELECT frequency FROM FilesPerProject WHERE nFiles = ?''', (numberOfFiles,))

        # oldFrequency will be a tuple like (1,) or null
        oldFrequency = c.fetchone()
        if not oldFrequency:
            c.execute("INSERT INTO FilesPerProject values (?,?)", (numberOfFiles, 1))
        else:
            c.execute("UPDATE FilesPerProject SET frequency=? WHERE nFiles=?", (oldFrequency[0] + 1, numberOfFiles))
        conn.commit()
        conn.close()

    # (uniqueSourceID int, sourceJSON text, scanID int, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)
    def record_regex_citation(self, uniqueSourceID, sourceJSON, fileHash, pythonFilePath, pattern, flags, regexFunction, report_db):
        logging.debug("PyReS - record_regex, uniqueSourceID: " + str(uniqueSourceID) + " sourceJSON: " + str(sourceJSON) + " fileHash: " + str(fileHash) + " filePath: " + str(pythonFilePath) + " pattern: " + str(pattern) + " flags: " + str(flags) + " regexFunction: " + str(regexFunction))
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO RegexCitation values (?,?,?,?,?,?,?)", (uniqueSourceID, sourceJSON, fileHash, pythonFilePath, pattern, flags, regexFunction))
        conn.commit()
        conn.close()

# ######################### helpers ###################################

    # def log(self, msg=""):
    #    logging.debug("PyReS - " + msg)

    # this is public so that the index mapping is not mysterious
    def get_function_list(self):
        return ["re.compile", "re.search", "re.match", "re.split", "re.findall", "re.finditer", "re.sub", "re.subn"]

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
            # note that arg0 is the regexFunction, arg1 is the pattern
            return regex_citation[2]
        elif regexFunction in [1, 2, 4, 5]:
            return regex_citation[3]
        elif regexFunction == 3:
            return regex_citation[4]
        elif regexFunction in [6, 7]:
            return regex_citation[5]
        else:
            logging.error("PyReS - extract_flags, cannot extract flags from " + str(regex_citation))
            return 0
