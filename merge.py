import util
import glob
import sqlite3
import json
import os

globalCounter = 0
globalRepoIDMap = {}


def insertNFiles(merged_report_db, row):
    numberOfFiles = row[0]
    frequency = row[1]
    conn = sqlite3.connect(merged_report_db)
    c = conn.cursor()
    c.execute('''SELECT frequency FROM FilesPerProjectMerged WHERE nFiles = ?''', (numberOfFiles,))

    # oldFrequency will be a tuple like (1,) or null
    oldFrequency = c.fetchone()
    if not oldFrequency:
        c.execute("INSERT INTO FilesPerProjectMerged values (?,?)", (numberOfFiles, frequency))
    else:
        c.execute("UPDATE FilesPerProjectMerged SET frequency=? WHERE nFiles=?", (oldFrequency[0] + frequency, numberOfFiles))
    conn.commit()
    conn.close()


def insertRegexCitation(merged_report_db, row, repoID):
    conn = sqlite3.connect(merged_report_db)
    c = conn.cursor()
    global globalCounter
    global globalRepoIDMap
    thisRecordUniqueSourceID = -1
    if repoID in globalRepoIDMap:
        thisRecordUniqueSourceID = globalRepoIDMap[repoID]
    else:
        globalRepoIDMap[repoID] = globalCounter
        thisRecordUniqueSourceID = globalCounter
        globalCounter += 1
    c.execute("INSERT INTO RegexCitationMerged values (?,?,?,?,?,?,?,?)", (thisRecordUniqueSourceID, repoID, row[1], row[2], row[3], row[4], row[5], row[6]))
    conn.commit()
    conn.close()


def insertRegexCitationOld(merged_report_db, row):
    conn = sqlite3.connect(merged_report_db)
    c = conn.cursor()
    repoID = row[1]
    global globalCounter
    global globalRepoIDMap
    thisRecordUniqueSourceID = -1
    if repoID in globalRepoIDMap:
        thisRecordUniqueSourceID = globalRepoIDMap[repoID]
    else:
        globalRepoIDMap[repoID] = globalCounter
        thisRecordUniqueSourceID = globalCounter
        globalCounter += 1
    c.execute("INSERT INTO RegexCitationMerged values (?,?,?,?,?,?,?,?)", (thisRecordUniqueSourceID, row[1], row[2], row[3], row[4], row[5], row[6], row[7]))
    conn.commit()
    conn.close()


def merge(merged_report_db, report_db):

    conn = sqlite3.connect(report_db)
    c = conn.cursor()
    it1 = c.execute('''SELECT * FROM RegexCitation ORDER BY uniqueSourceID''')
    for row1 in it1:
        sourceJSONObject = json.loads(row1[1])
        repoID = int(sourceJSONObject["meta"]["repoID"])
        insertRegexCitation(merged_report_db, row1, repoID)
    it2 = c.execute('''SELECT * FROM FilesPerProject ORDER BY nFiles''')
    for row2 in it2:
        insertNFiles(merged_report_db, row2)
    conn.close()


def mergeOld(merged_report_db, report_db):

    conn = sqlite3.connect(report_db)
    c = conn.cursor()
    it1 = c.execute('''SELECT * FROM RegexCitationMerged ORDER BY uniqueSourceID''')
    for row1 in it1:
        insertRegexCitationOld(merged_report_db, row1)
    it2 = c.execute('''SELECT * FROM FilesPerProjectMerged ORDER BY nFiles''')
    for row2 in it2:
        insertNFiles(merged_report_db, row2)
    conn.close()


def isNew(dbName):
    isNew = False
    conn = sqlite3.connect(dbName)
    c = conn.cursor()

    # only new databases will have a table named RegexCitation
    c.execute('''SELECT count(*) FROM sqlite_master WHERE type="table" AND name="RegexCitation"''')
    result = c.fetchone()
    print "result " + str(result)
    isNew = result[0] == 1
    conn.commit()
    conn.close()
    return isNew


def initialize_merged_report(merged_report_db):
    conn = sqlite3.connect(merged_report_db)
    c = conn.cursor()

    # notice the extra repoID field
    c.execute('''CREATE TABLE RegexCitationMerged (uniqueSourceID int, repoID int, sourceJSON text, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)''')
    c.execute('''CREATE TABLE FilesPerProjectMerged (nFiles int, frequency int)''')
    conn.commit()
    conn.close()


def mergeAny(merged_report_db, otherDatabase):
    if isNew(otherDatabase):
        merge(merged_report_db, otherDatabase)
    else:
        mergeOld(merged_report_db, otherDatabase)


# merging script
cloneNames = ["bib", "gum", "rat", "yen"]
MERGED_PATH = util.LOCAL_PATH + "merged/"
merged_report_db = MERGED_PATH + "merged_report.db"

# clean out the old one, if it is there
if os.path.isfile(merged_report_db):
    os.remove(merged_report_db)
    print "removed old merged_report_db.db"
initialize_merged_report(merged_report_db)

for name in cloneNames:
    for i in range(1, 9):
        dataPath = util.LOCAL_PATH + "clones/" + name + "/tour_de_source" + str(i) + "/data/"
        dbNames = glob.glob(dataPath + "*.db")

        # allow but warn empty data directories
        if len(dbNames) == 0:
            print "empty path: " + dataPath
            continue
        reportNames = [x for x in dbNames if x != (dataPath + "tour.db")]

        # do not allow merging with multiple databases
        if len(reportNames) > 1:
            raise RuntimeWarning("length of reportNames: " + str(len(reportNames)) + " in datPath: " + dataPath + " ... " + str(reportNames))
        report = reportNames[0]

        # do the merge
        print "merging with report: " + report
        merge(merged_report_db, report)

for otherDatabase in [db for db in glob.glob(MERGED_PATH + "*.db") if db != merged_report_db]:
    print "would merge otherdatabase: " + otherDatabase
    # mergeAny(merged_report_db, otherDatabase)
print "merge complete"
