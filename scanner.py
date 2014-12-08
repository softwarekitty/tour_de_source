import sqlite3
import astroid.manager
import astroid.as_string
import astroid.node_classes
import astroid.inspector
import logging
import util


class PythonRegexScanner:
    id = "python regex scanner"

    # regex_flags = ["IGNORECASE","DEBUG","LOCALE","MULTILINE","DOTALL","UNICODE","VERBOSE"]

    def initialize_report(self, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute('''CREATE TABLE name (Regex) (scanID int, fileID int, regexFunction int, pattern text, flags int)''')
        c.execute('''CREATE TABLE name (File) (cuteHash char(44), filePath text, scanID int)''')
        conn.commit()
        conn.close()

    def record_regex(self, scanID, fileID, regexFunction, pattern, flags, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO Regex values (?,?,?,?,?)", (scanID, fileID, regexFunction, pattern, flags))
        conn.commit()
        conn.close()

    def db_contains_file(self, cuteHash, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("SELECT EXISTS(SELECT 1 FROM File WHERE cuteHash=? LIMIT 1)", cuteHash)
        found = c.fetchone()
        conn.commit()
        conn.close()
        if found:
            return True
        else:
            return False

    def registerFilePath(self, cuteHash, filePath, scanID, report_db):
        conn = sqlite3.connect(report_db)
        c = conn.cursor()
        c.execute("INSERT INTO File values (?,?,?)", (cuteHash, filePath, scanID))
        lastRow = c.lastrowid
        conn.commit()
        conn.close()
        return lastRow

    # filePaths is a list of python file paths to scan
    def extract_regex(self, filePaths, scanID, report_db):
        for filePath in filePaths:
            # print("parsing file: "+file)

            # hash to avoid re-scanning identical files.
            cuteHash = util.get_cuteHash(filePath)
            if not self.db_contains_file(cuteHash, report_db):
                fileID = self.registerFilePath(cuteHash, filePath, scanID, report_db)
                node = astroid.manager.AstroidManager().ast_from_file(filePath)
                self.extractRegexR(node, fileID, scanID, report_db)
            # print("returning regexes: "+str(regexes))

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
                        print("unexpected class found: " + x.__class__.__name__)

                elif isinstance(x, astroid.node_classes.Name):
                    regex_citation[arg_counter] = x.infer().next().as_string()
                elif isinstance(x, astroid.node_classes.Const):
                    regex_citation[arg_counter] = x.as_string()
                else:
                    print("unexpected class found: " + x.__class__.__name__)
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
            logging.error("cannot extract flags from " + regex_citation)
            return 0
