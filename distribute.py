import shutil
from os.path import expanduser

HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"

# ignoreFileNames = ["merge.py", "distribute.py", "main.py", "util.py", "webappIdea.py", "clean.py"]
# ignoreFilesList = [util.BASE_PATH + g for g in ignoreFileNames]
# pythonFilesInRoot = glob.glob(util.BASE_PATH + "*.py")

# filesToDistribute = [filename for filename in pythonFilesInRoot if filename not in ignoreFilesList]


with open(LOCAL_PATH + "main.py", "r") as mainFile:
        mainString = mainFile.read()
        parts = mainString.split("# SPLIT_HERE\n")

clonesPerMachine = 8

cloneNames = ["bib", "gum", "rat", "yen"]
robotNames = [["a", "b", "c", "d", "e", "f", "g", "h"], ["a", "b", "c", "d", "e", "f", "g", "h"], ["a", "b", "c", "d", "e", "f", "g", "h"], ["a", "b", "c", "d", "e", "f", "g", "h"]]
credentials = [["KendrickMurray:kos8izjfc4dnsa", "KendrickMurray2:kos8izjfc4dnsa", "KendrickMurray3:kos8izjfc4dnsa", "KendrickMurray4:kos8izjfc4dnsa", "KendrickMurray5:kos8izjfc4dnsa", "KendrickMurray6:kos8izjfc4dnsa", "KendrickMurray7:kos8izjfc4dnsa", "KendrickMurray8:kos8izjfc4dnsa"], ["KendrickMurray9:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa"], ["KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa"], ["KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa", "KendrickMurray:kos8izjfc4dnsa"]]
j = 0
chunk = 1000
for name in cloneNames:
    for i in range(0, clonesPerMachine):
        cloneSuffix = "clones/" + name + "/tour_de_source" + str(i + 1) + "/"
        basePath = LOCAL_PATH + cloneSuffix
        cred = credentials[j][i]
        first = (chunk * clonesPerMachine * j) + chunk * i
        stop = first + chunk - 1
        # first = 15249309
        # stop = 15249309
        newMiddlePart = 'cloneSuffix = "' + cloneSuffix + '"\ncredentials = "' + cred + '"\nfirst = ' + str(first) + '\nstop = ' + str(stop) + '\nendingMessage = "Tour of ' + robotNames[j][i] + ' ended with status: "\n\n'
        newMain = parts[0] + newMiddlePart + parts[2]
        fo = open(basePath + "main.py", "w")
        fo.write(newMain)
    j += 1
    exit()
print "done distributing"
