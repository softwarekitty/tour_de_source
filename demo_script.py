from depot import Depot
from tourist import Tourist
from sourcer import GithubPythonSourcer
from scanner import PythonRegexScanner


d = Depot()
e = "investigationbot@gmail.com"
s = [GithubPythonSourcer("Version")]
t = Tourist(d, e, PythonRegexScanner(), s)
t.tour()
