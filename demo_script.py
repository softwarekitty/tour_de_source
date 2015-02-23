from depot import Depot
from tourist import Tourist
# from sourcer import GithubPythonSourcer
from sourcer import LocalTestSourcer
from scanner import PythonRegexScanner
import logging

logging.basicConfig(
    filename="demo_script.log",
    level=logging.DEBUG,
    # format='[%(asctime)s] {%(pathname)s:%(lineno)d} %(levelname)s - %(message)s',
    format='%(levelname)s - %(message)s',
    datefmt='%H:%M:%S'
)

# console = logging.StreamHandler()
# console.setLevel(logging.DEBUG)
# formatter = logging.Formatter('%(name)-12s: %(levelname)-8s %(message)s')
# # add the handler to the root logger
# logging.getLogger('').addHandler(console)
# logger = logging.getLogger(__name__)


d = Depot()
e = "investigationbot@gmail.com"
s = [LocalTestSourcer("copycat_test_sourcer")]
# s = [GithubPythonSourcer("MasterAndTags")]
t = Tourist(d, e, PythonRegexScanner(), s)
t.tour()
