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
import logging.handlers
import sh
from os.path import expanduser

HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"

BASE_PATH = LOCAL_PATH + "clones/yen/tour_de_source5/"


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


def test_get_cuteHash_fileExists():
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

LOG_DEBUG_FILENAME = BASE_PATH + "data/log/tour_de_source.debug.log"

LOG_CRITICAL_FILENAME = BASE_PATH + "data/log/tour_de_source.critical.log"


def getConsoleHandler():
    console = logging.StreamHandler()
    console.setLevel(logging.INFO)
    formatter = logging.Formatter("%(levelname)s-%(message)s")
    console.setFormatter(formatter)
    return console


def getRotatingFileHandler():
    rotating = logging.handlers.RotatingFileHandler(filename=LOG_DEBUG_FILENAME, maxBytes=4194304, backupCount=999, delay=False)
    formatter = logging.Formatter("%(asctime)s %(levelname)s-%(message)s", '%a, %d %b %H:%M:%S')
    rotating.setFormatter(formatter)
    rotating.setLevel(logging.DEBUG)
    return rotating


def getGmailRotatingFileHandler(email, password, to):
    gmailing = RotatingFileGmailHandler(LOG_CRITICAL_FILENAME, email, password, to, "CRITICAL Log Report", maxBytes=4194304, backupCount=999, delay=False)
    formatter = logging.Formatter("%(asctime)s %(message)s", '%H:%M:%S')
    gmailing.setFormatter(formatter)
    gmailing.setLevel(logging.CRITICAL)
    return gmailing


def prepareLogging(email, password, to):
    # erase old logging files if any exist
    try:
        sh.cd(BASE_PATH + "data/log")
        sh.rm('-r', sh.glob('./*'))
    except:
        pass
    logger = logging.getLogger('')
    logger.setLevel(logging.DEBUG)
    logger.addHandler(getConsoleHandler())
    logger.addHandler(getRotatingFileHandler())
    logger.addHandler(getGmailRotatingFileHandler(email, password, to))
    return logger


def emailEndingMessage(email, password, to, subject):
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
