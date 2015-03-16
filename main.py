from depot import Depot
from tourist import Tourist
from sourcer import GithubPythonSourcer
from sourcer import LocalTestSourcer
from scanner import PythonRegexScanner
import util


e = "investigationbot@gmail.com"
p = "cro0thiezlutrl"
to = "carlallenchapman@gmail.com"
l = util.prepareLogging(e, p, to)


d = Depot(l)
s = [LocalTestSourcer("copycat_test_sourcer", e, p, l)]
# self.since = 15249308 will be a small, fast repo, 15249311 is two repos later
# s = [GithubPythonSourcer("20Commits", e, p, l, 15249309, 15249409)]
t = Tourist(d, e, PythonRegexScanner(l), s, l)
t.tour()
