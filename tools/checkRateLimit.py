from os.path import expanduser
HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"
import sys
sys.path.append(LOCAL_PATH)

import util
import json
import urllib2


def checkRateLimit(credentials):
    check_limit_url = "https://api.github.com/rate_limit"
    rateJSON = json.load(urllib2.urlopen(util.get_authorized_request(check_limit_url, credentials)))
    limit_remaining = rateJSON['resources']['core']['remaining']
    return limit_remaining


username1 = "investigationbot"
username2 = "investigationrat"
username3 = "investigationyak"
password1 = "cro0thiezlutrl"
password2 = "adjutasfc4dnsa"
password3 = "kos8izjrv3oary"


credentials = username1 + ":" + password1
print "limit remaining for " + username1 + ": " + str(checkRateLimit(credentials))
credentials = username2 + ":" + password2
print "limit remaining for " + username2 + ": " + str(checkRateLimit(credentials))
credentials = username3 + ":" + password3
print "limit remaining for " + username3 + ": " + str(checkRateLimit(credentials))
