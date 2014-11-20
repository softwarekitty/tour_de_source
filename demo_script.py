from depot import Depot
from tourist import Tourist
from scanner import PythonRegexScanner


d = Depot()
t = Tourist(d.DB, PythonRegexScanner())
t.beginTour()
