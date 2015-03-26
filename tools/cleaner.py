import glob
import os
import shutil
from os.path import expanduser

HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"

cloneNames = ["bib", "gum", "rat", "yen"]

for name in cloneNames:
    for i in range(1, 9):
        basePath = LOCAL_PATH + "clones/" + name + "/tour_de_source" + str(i) + "/"
        dataPath = basePath + "data/"
        # remove all python files?
        print "basepath: " + basePath
        for f in glob.glob(basePath + "*.pyc"):
            print "removing: " + f
            os.remove(f)
        for f in glob.glob(dataPath + "*.db"):
            os.remove(f)
        for x in glob.glob(dataPath + "log/*"):
            os.remove(x)
        for y in glob.glob(basePath + "repo/*"):
            if os.path.isfile(y):
                os.remove(y)
            else:
                shutil.rmtree(y)
print "done deleting all logs, repos and databases"
