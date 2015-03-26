import uuid
import calendar
import time
import sqlite3
import hashlib
from datetime import datetime
import smtplib
from email.MIMEMultipart import MIMEMultipart
from logging.handlers import RotatingFileHandler
from email.MIMEBase import MIMEBase
from email.MIMEText import MIMEText
from email import Encoders
import logging
import os
import base64
import json
import urllib2
import random
import logging.handlers
import glob
import commands


def get_cuteHash(filePath):
    with open(filePath, "r") as fileHandle:
        content = fileHandle.read()
        h = hashlib.sha224(content)
        iHash = int(h.hexdigest(), 16)
        return base36encode(iHash)


def getUniqueCuteID(length, tour_db):
    proposedID = getCuteID(length)
    searching = True
    while searching:
        if not dbContainsID(proposedID, tour_db):
            return proposedID
        else:
            proposedID = getCuteID(length)


def dbContainsID(proposedID, tour_db):
    containsID = True
    conn = sqlite3.connect(tour_db)
    c = conn.cursor()
    c.execute('SELECT * FROM Tour WHERE id=?', (proposedID,))
    if not bool(c.fetchone()):
        containsID = False
    conn.commit()
    conn.close()
    return containsID


def getCuteID(length):
    actualLength = length if length > 0 and length < 25 else 24
    return base36encode(uuid.uuid4().int)[0:actualLength]


def getDateTimeS(dateTime_input):
    return calendar.timegm(dateTime_input.utctimetuple())


# this will fail sometimes due to the randomness
def test_getCuteID():
    PROPOSED_ID_SIZE = 6
    # testStart = datetime.datetime.now()
    seed = []
    seed.append(getCuteID(PROPOSED_ID_SIZE))
    collection = set(seed)
    no_repeats = True
    counter = 0
    while no_repeats:
        newID = getCuteID(PROPOSED_ID_SIZE)
        if newID in collection:
            no_repeats = False
        if counter % 500 == 0:
            print "counter: " + str(counter) + " ID: " + newID
        collection.add(newID)
        counter += 1
    # testFinish = datetime.datetime.now()
    # delta = testFinish - testStart
    # halfSecond = datetime.timedelta(milliseconds=500)
    assert 20000 < counter


def test_getDateTimeS():
    start = getDateTimeS(datetime.now())
    time.sleep(2)
    print start
    assert start < getDateTimeS(datetime.now())


def test_get_cuteHash_fileExists(BASE_PATH):
    safePath = BASE_PATH + "repo/testFile.txt"
    with open(safePath, 'w+') as testFile:
        testFile.write('12345678')
    cuteHash = get_cuteHash(safePath)
    assert cuteHash == '1lhjps3myz35yhr7cad4j81jdz5fym7oekjcacq1atht'


# cite: https://gist.github.com/kfr2/4287546
def base36encode(number):
    """Converts an integer into a base36 string."""
    ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz"
    if not isinstance(number, (int, long)):
        raise TypeError('This function must be called on an integer.')
    base36 = ''
    sign = ''
    if number < 0:
        sign = '-'
        number = -number
    if 0 <= number < len(ALPHABET):
        return sign + ALPHABET[number]
    while number != 0:
        number, i = divmod(number, len(ALPHABET))
        base36 = ALPHABET[i] + base36
    return sign + base36


# no exception if successfully able to erase whatever is at path
def erasePath(path, logger=None):
    os.chmod(path, 0777)
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


def get_authorized_request(url, credentials):
    encoded64 = base64.encodestring(credentials).replace('\n', '')
    request = urllib2.Request(url)
    request.add_header("Authorization", "Basic %s" % encoded64)
    return request


def get_json(logger, url, credentials, randWait=False):
    maxOfRange = 7
    randNapS = 2
    if randWait:
        randPick = random.randrange(maxOfRange)
        if randPick == 0:
            time.sleep(randNapS)

    attempt_counter = 0
    attempt_limit = 5
    backoff_counter = 1
    max_waitS = 180

    # keep trying until we get the json from github
    while True:
        emergency_waitS = 2 ** backoff_counter
        if emergency_waitS < max_waitS:
            backoff_counter += 1
        else:
            emergency_waitS = max_waitS

        try:
            # first check rate limit - does not count against you
            check_limit_url = "https://api.github.com/rate_limit"
            rateJSON = json.load(urllib2.urlopen(get_authorized_request(check_limit_url, credentials)))
            limit_remaining = rateJSON['resources']['core']['remaining']
            if limit_remaining % 10 == 0:
                logger.info("GiPyS - limit_remaining: " + str(limit_remaining))

            # don't push the rate limit if none remain - wait for reset
            if limit_remaining <= 1:
                limit_resetS = rateJSON['resources']['core']['reset']
                nowS = calendar.timegm(time.gmtime())
                time_to_waitS = limit_resetS - (nowS - 2)
                logger.critical("GiPyS - get_json, blocked by rate limit: " + str(limit_remaining) + " ttwS: " + str(time_to_waitS))
                time.sleep(time_to_waitS)

            urlJSON = json.load(urllib2.urlopen(get_authorized_request(url, credentials)))
            logger.debug("GiPyS - get_json Success, url: " + url + " limit_remaining: " + str(limit_remaining))
            return urlJSON
        except urllib2.HTTPError, e:
            logger.error("GiPyS - get_json, HTTPError!!!")
        except Exception as e:
            logger.critical("GiPyS - get_json, Unexpected roblem with getting json: " + str(e))

        # break out of this cycle for troublesome urls
        attempt_counter += 1
        if attempt_counter >= attempt_limit:
            logger.critical("GiPyS - get_json, Giving up on url " + url + " after " + str(attempt_counter) + " attempts")
            raise Exception("this url is not worth the trouble: " + url)

        # back off a random time to avoid looking like such a robot
        backoffS = random.randrange(emergency_waitS)
        logger.warning("GiPyS - get_json, backing off with backoffS: " + str(backoffS) + " attempt: " + str(attempt_counter) + "/" + str(attempt_limit) + " url: " + url)
        time.sleep(backoffS)


# modified from python 2.7.5 source...
class RotatingFileGmailHandler(RotatingFileHandler):
    """
    Handler for logging to a set of files, which switches from one file
    to the next when the current file reaches a certain size.
    """
    def __init__(self, filename, email, password, to, subject, mode='a', maxBytes=0, backupCount=0, encoding=None, delay=0):
        """
        Open the specified file and use it as the stream for logging.

        By default, the file grows indefinitely. You can specify particular
        values of maxBytes and backupCount to allow the file to rollover at
        a predetermined size.

        Rollover occurs whenever the current log file is nearly maxBytes in
        length. If backupCount is >= 1, the system will successively create
        new files with the same pathname as the base file, but with extensions
        ".1", ".2" etc. appended to it. For example, with a backupCount of 5
        and a base file name of "app.log", you would get "app.log",
        "app.log.1", "app.log.2", ... through to "app.log.5". The file being
        written to is always "app.log" - when it gets filled up, it is closed
        and renamed to "app.log.1", and if files "app.log.1", "app.log.2" etc.
        exist, then they are renamed to "app.log.2", "app.log.3" etc.
        respectively.

        If maxBytes is zero, rollover never occurs.
        """
        # If rotation/rollover is wanted, it doesn't make sense to use another
        # mode. If for example 'w' were specified, then if there were multiple
        # runs of the calling application, the logs from previous runs would be
        # lost if the 'w' is respected, because the log file would be truncated
        # on each run.
        if maxBytes > 0:
            mode = 'a'
        RotatingFileHandler.__init__(self, filename, mode, maxBytes, backupCount, encoding, delay)
        self.email = email
        self.password = password
        self.to = to
        self.subject = subject
        self.maxBytes = maxBytes
        self.backupCount = backupCount

    def doRollover(self):
        """
        Do a rollover, as described in __init__().
        """
        if self.stream:
            self.stream.close()
            self.stream = None
        if self.backupCount > 0:
            for i in range(self.backupCount - 1, 0, -1):
                sfn = "%s.%d" % (self.baseFilename, i)
                dfn = "%s.%d" % (self.baseFilename, i + 1)
                if os.path.exists(sfn):
                    # print "%s -> %s" % (sfn, dfn)
                    if os.path.exists(dfn):
                        os.remove(dfn)
                    os.rename(sfn, dfn)
            dfn = self.baseFilename + ".1"
            if os.path.exists(dfn):
                os.remove(dfn)
            self.gmailOldLogFile(self.baseFilename)
            os.rename(self.baseFilename, dfn)
            # print "%s -> %s" % (self.baseFilename, dfn)
        self.stream = self._open()

    def gmailOldLogFile(self, filename):
        msg = MIMEMultipart()
        msg['From'] = self.email
        msg['To'] = self.to
        msg['Subject'] = self.subject
        msg.attach(MIMEText("progress report: log file is full"))

        part = MIMEBase('application', "octet-stream")
        part.set_payload(open(filename, "rb").read())
        Encoders.encode_base64(part)
        part.add_header('Content-Disposition', 'attachment; filename="%s"' % os.path.basename(filename))
        msg.attach(part)

        mailServer = smtplib.SMTP("smtp.gmail.com", 587)
        mailServer.ehlo()
        mailServer.starttls()
        mailServer.ehlo()
        mailServer.login(self.email, self.password)
        mailServer.sendmail(self.email, self.to, msg.as_string())
        mailServer.close()


def getConsoleHandler():
    console = logging.StreamHandler()
    console.setLevel(logging.INFO)
    formatter = logging.Formatter("%(levelname)s-%(message)s")
    console.setFormatter(formatter)
    return console


def getRotatingFileHandler(LOG_DEBUG_FILENAME):
    rotating = logging.handlers.RotatingFileHandler(filename=LOG_DEBUG_FILENAME, maxBytes=4194304, backupCount=999, delay=False)
    formatter = logging.Formatter("%(asctime)s %(levelname)s-%(message)s", '%a, %d %b %H:%M:%S')
    rotating.setFormatter(formatter)
    rotating.setLevel(logging.DEBUG)
    return rotating


def getGmailRotatingFileHandler(email, password, to, LOG_CRITICAL_FILENAME):
    gmailing = RotatingFileGmailHandler(LOG_CRITICAL_FILENAME, email, password, to, "CRITICAL Log Report", maxBytes=4194304, backupCount=999, delay=False)
    formatter = logging.Formatter("%(asctime)s %(message)s", '%H:%M:%S')
    gmailing.setFormatter(formatter)
    gmailing.setLevel(logging.CRITICAL)
    return gmailing


def prepareLogging(email, password, to, BASE_PATH, LOG_DEBUG_FILENAME, LOG_CRITICAL_FILENAME):
    LOG_PATH = BASE_PATH + "data/log/"
    if not os.path.exists(LOG_PATH):
        os.makedirs(LOG_PATH)

    # erase old logging files if any exist
    try:
        for x in glob.glob(BASE_PATH + "data/log/.*"):
            erasePath(x)
    except Exception as e:
        raise RuntimeWarning("failure to erase old logs with exception: " + e.strerror)

    logger = logging.getLogger('')
    logger.setLevel(logging.DEBUG)
    logger.addHandler(getConsoleHandler())
    logger.addHandler(getRotatingFileHandler(LOG_DEBUG_FILENAME))
    logger.addHandler(getGmailRotatingFileHandler(email, password, to, LOG_CRITICAL_FILENAME))
    return logger


def emailEndingMessage(email, password, to, subject, LOG_CRITICAL_FILENAME):
    msg = MIMEMultipart()
    msg['From'] = email
    msg['To'] = to
    msg['Subject'] = subject
    msg.attach(MIMEText("progress report: the tour has ended"))

    part = MIMEBase('application', "octet-stream")
    part.set_payload(open(LOG_CRITICAL_FILENAME, "rb").read())
    Encoders.encode_base64(part)
    part.add_header('Content-Disposition', 'attachment; filename="%s"' % os.path.basename(LOG_CRITICAL_FILENAME))
    msg.attach(part)

    mailServer = smtplib.SMTP("smtp.gmail.com", 587)
    mailServer.ehlo()
    mailServer.starttls()
    mailServer.ehlo()
    mailServer.login(email, password)
    mailServer.sendmail(email, to, msg.as_string())
    mailServer.close()
