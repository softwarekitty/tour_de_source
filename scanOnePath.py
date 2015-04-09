import sys
import os
import git
import rewinder
import scanner
import sqlite3


def initialize_report(report_db):
    conn = sqlite3.connect(report_db)
    c = conn.cursor()
    c.execute('''CREATE TABLE RegexCitation (repoID int, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)''')
    c.execute('''CREATE TABLE FilesPerProject (nFiles int, frequency int)''')
    conn.commit()
    conn.close()

print 'Argument List:', str(sys.argv)
basePath = sys.argv[1]
repoID = sys.argv[2]
dbPath = sys.argv[3]

try:
    initialize_report(dbPath)
except:
    pass
repoIDPath = basePath + "/" + str(repoID)

# assume that we already have the repo cloned in basePath / repoID
# assume that the report_db has already been initialized! with this schema:
# '''CREATE TABLE RegexCitation (repoID int, fileHash char(44), filePath text, pattern text, flags int, regexFunction int)'''
# '''CREATE TABLE FilesPerProject (nFiles int, frequency int)'''

# just to be safe, always do these sanity checks.
# the repoIDPath should exist and contain the new ".git" every time.
if not os.path.exists(repoIDPath):
    print"path missing!"
    raise RuntimeWarning("do not proceed with repoIDPath directory missing - you will rewind the tour_de_source project!")
repoIDPathContents = [os.path.join(repoIDPath, f) for f in os.listdir(repoIDPath)]
print "contents of pathToScan: " + str(repoIDPathContents)
if not repoIDPathContents:
    print"repoIDPathContents is empty!"
    raise RuntimeWarning("do not proceed with repoIDPath directory empty - you will rewind the tour_de_source project!")
if repoIDPath + "/.git" not in repoIDPathContents:
    print "repoIDPathContents has no git!  cloning did not succeed."
    raise RuntimeWarning("do not proceed with repoIDPath directory having no .git folder - you will rewind the tour_de_source project!")

# now get the time and sha for commits
commitList = []
repoGit = git.Git(repoIDPath)
hexshas = repoGit.log("--format=format:\"%ct %H\"").split('\n')
for line in hexshas:
    cleanedLine = line[line.find('"') + 1:line.rfind('"')]
    pair = cleanedLine.split(' ')
    if len(pair) == 2:
        commitList.append((pair[0], pair[1]))
print 'len(hexshas):', str(len(hexshas))
n = 10
# here we are sorting by the first field of the tuple: the commit time
commitList.sort(reverse=True)
nCommits = len(commitList)
if nCommits <= n:
    # return a rewinder with all commits
    stack = commitList
else:
    # return a rewinder with n commits, spaced out about evenly
    unitFloat = nCommits / float(n - 1)
    stack = []

    # always put the most recent first
    stack.append(commitList[0])

    # put the rest
    for multiplier in range(1, n):
        commitIndex = int(multiplier * unitFloat) - 1
        stack.append(commitList[commitIndex])

# remember python lists pop at the tail...
# self, path, repoID, stack
stack.reverse()
r = rewinder.GitRewinderBasic(repoIDPath, repoID, stack)
basicScanner = scanner.BasicScanner()

shaSet = []
filePathSet = []
citationSet = []
# self, path, report_db, repoID, shaSet, filePathSet, citationSet
while r.rewind():
    basicScanner.scanDirectory(repoIDPath, dbPath, repoID, shaSet, filePathSet, citationSet)
print "done w/repoID " + str(repoID) + " nFiles: " + str(len(filePathSet)) + " nCites: " + str(len(citationSet))
basicScanner.incrementFilesPerProject(len(filePathSet), dbPath)
consecutiveExceptionCounter = 0

# assume this will be done elsewhere too.
# basicScanner.setFilesPerProject(-1, s.getNProjects(), dbPath)
# basicScanner.setFilesPerProject(-2, s.nRefreshRepoFailures(), dbPath)
# basicScanner.setFilesPerProject(-3, s.nGetRewinderFailures(), dbPath)
