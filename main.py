from depot import Depot
from tourist import Tourist
from tourist import LookiLoo
from sourcer import GithubPythonSourcer
from sourcer import LocalTestSourcer
from scanner import PythonRegexScanner
import util


e1 = "investigationbot@gmail.com"
p1 = "cro0thiezlutrl"
credentials = "investigationbot:cro0thiezlutrl"

to = "carlallenchapman@gmail.com"
l = util.prepareLogging(e1, p1, to)


d = Depot(l)

# test scanner or quickly send finished email
# s = [LocalTestSourcer("copycat_test_sourcer", e, p, l)]
# t = Tourist(d, e, p, to, PythonRegexScanner(l), s, l)


# test github interactions
# s = [GithubPythonSourcer("mock", e, p, l)]
# t = LookiLoo(d, e, p, to, PythonRegexScanner(l), s, l)

# test normal operation or run normally
# self.since = 15249308 will be a small, fast repo, 15249311 is two repos later
s = [GithubPythonSourcer("20Commits", e1, p1, l, credentials, 15249309, 15249311)]
t = Tourist(d, e1, p1, to, PythonRegexScanner(l), s, l, "Tour of bot1 ended with status: ")


t.tour()
