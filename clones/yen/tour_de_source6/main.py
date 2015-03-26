from os.path import expanduser
HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"
import sys
sys.path.append(LOCAL_PATH)

import util
from depot import Depot
from tourist import Tourist
# from tourist import LookiLoo
from sourcer import GithubPythonSourcer
# from sourcer import LocalTestSourcer
from scanner import PythonRegexScanner


cloneSuffix = "clones/yen/tour_de_source6/"
credentials = "DouglasGarcia:o88ZuSq83N93OgaB6"
first = 3801088
stop = 3932159
endingMessage = "Tour of yen_6 ended with status: "


BASE_PATH = LOCAL_PATH + cloneSuffix
LOG_PATH = BASE_PATH + "data/log/"
LOG_DEBUG_FILENAME = LOG_PATH + "tour_de_source.debug.log"
LOG_CRITICAL_FILENAME = LOG_PATH + "tour_de_source.critical.log"


# now make blank logging files
open(LOG_DEBUG_FILENAME, 'a').close()
open(LOG_CRITICAL_FILENAME, 'a').close()


e1 = "investigationbot@gmail.com"
p1 = "cro0thiezlutrl"

to = "carlallenchapman@gmail.com"
l = util.prepareLogging(e1, p1, to, BASE_PATH, LOG_DEBUG_FILENAME, LOG_CRITICAL_FILENAME)


d = Depot(l, BASE_PATH)
# test scanner or quickly send finished email
# s = [LocalTestSourcer("copycat_test_sourcer", e1, p1, l, bp=BASE_PATH)]
# t = Tourist(d, e1, p1, to, PythonRegexScanner(l), s, l, "LocalTestSourcer tour ended with status: ", LOG_CRITICAL_FILENAME)


# test github interactions
# s = [GithubPythonSourcer("mock", e1, p1, l)]
# t = LookiLoo(d, e1, p1, to, PythonRegexScanner(l), s, l, "Lookilo finished with status: ", LOG_CRITICAL_FILENAME)

# test normal operation or run normally
# 15249309 will be a small, fast repo, 15249311 is two repos later
s = [GithubPythonSourcer("20Commits", e1, p1, l, credentials, first, stop)]
t = Tourist(d, e1, p1, to, PythonRegexScanner(l), s, l, endingMessage, LOG_CRITICAL_FILENAME)


t.tour()
