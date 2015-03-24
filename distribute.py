import util
import glob
import shutil

ignoreFileNames = ["merge.py", "distribute.py", "main.py", "util.py", "webappIdea.py", "clean.py"]
ignoreFilesList = [util.BASE_PATH + g for g in ignoreFileNames]
pythonFilesInRoot = glob.glob(util.BASE_PATH + "*.py")

filesToDistribute = [filename for filename in pythonFilesInRoot if filename not in ignoreFilesList]

cloneNames = ["bib", "gum", "rat", "yen"]

for name in cloneNames:
    for i in range(1, 9):
        basePath = util.LOCAL_PATH + "clones/" + name + "/tour_de_source" + str(i) + "/"
        for f in filesToDistribute:
            print "distributing " + str(f)
            shutil.copy(f, basePath)
print "done distributing"
