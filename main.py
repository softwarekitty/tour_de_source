import util
from depot import Depot
from tourist import Tourist
from tourist import LookiLoo
from sourcer import GithubPythonSourcer
from sourcer import LocalTestSourcer
from scanner import PythonRegexScanner
from os.path import expanduser


HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"
import sys
sys.path.append(LOCAL_PATH)

# this is true only for the clones:
# BASE_PATH = LOCAL_PATH + "clones/bib/tour_de_source1/"
BASE_PATH = LOCAL_PATH

LOG_DEBUG_FILENAME = BASE_PATH + "data/log/tour_de_source.debug.log"

LOG_CRITICAL_FILENAME = BASE_PATH + "data/log/tour_de_source.critical.log"


e1 = "investigationbot@gmail.com"
p1 = "cro0thiezlutrl"
smallWords = ["bat", "bee", "bib", "bog", "boo", "box", "bum", "bus"]

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
s = [GithubPythonSourcer("20Commits", e1, p1, l, "investigation" + smallWords[0] + ":whorysq5im5ztb", 15249309, 15249311)]
t = Tourist(d, e1, p1, to, PythonRegexScanner(l), s, l, "Tour of bot1 ended with status: ", LOG_CRITICAL_FILENAME)


t.tour()
