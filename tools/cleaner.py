import glob
import os
import shutil
import commands


# no exception if successfully able to erase whatever is at path
def erasePath(path, logger=None):
    if os.path.isfile(path):
        try:
            os.remove(path)
        except Exception as e:
            if logger:
                logger.warning("failure to erase file: " + path + " exception: " + e.strerror)
            raise e
    else:
        try:
            cmd = "rm -rf " + path
            result = commands.getstatusoutput(cmd)
            if result is None:
                raise RuntimeWarning("None result in util.erasePath")
            if result[0] != 0:
                raise RuntimeWarning("util.erasePath has non-zero result for trying to delete path: " + path)
        except Exception as e:
            if logger:
                logger.warning("failure to erase non-file: " + path + " exception: " + e.strerror)
            raise e


def eraseAt(basePath, eraseAll=False):
    contents = [os.path.join(basePath, f) for f in os.listdir(basePath)]
    if contents:
        for x in contents:
            if os.path.isfile(x) or eraseAll:
                print "erasing: " + x
                erasePath(x)


# get the correct local path
from os.path import expanduser
HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"

proceed = input("the path to be cleaned is " + LOCAL_PATH + " to proceed type 1\n")
if not proceed == 1:
    exit()

cloneNames = ["bib", "gum", "rat", "yen"]

for name in cloneNames:
    for i in range(1, 9):

        basePath = LOCAL_PATH + "clones/" + name + "/tour_de_source" + str(i) + "/"
        if not os.path.exists(basePath):
            print "creating path: " + basePath
            os.makedirs(basePath)
        if not os.path.exists(basePath + "repo/"):
            print "creating path: " + basePath + "repo/"
            os.makedirs(basePath + "repo/")
        if not os.path.exists(basePath + "data/"):
            print "creating path: " + basePath + "data/"
            os.makedirs(basePath + "data/")
        if not os.path.exists(basePath + "data/log/"):
            print "creating path: " + basePath + "data/log/"
            os.makedirs(basePath + "data/log/")
        eraseAt(basePath)
        eraseAt(basePath + "data/")
        eraseAt(basePath + "data/log/")
        eraseAt(basePath + "repo/", True)
print "done deleting all logs, repos and databases"
