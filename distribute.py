import util
import glob

ignoreFilesList = ["merge.py", "distribute.py", "main.py", "util.py"]

pythonFilesInRoot = glob.glob(util.BASE_PATH + "./*.py")

filesToDistribute = [filename for filename in pythonFilesInRoot if filename not in ignoreFilesList]

cloneNames = ["bib", "gum", "rat", "yen"]

for name in cloneNames:
    for i in range(1, 9):
        dataPath = util.LOCAL_PATH + "clones/" + name + "/tour_de_source" + str(i) + "/data/"
