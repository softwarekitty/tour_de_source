import uuid
import calendar
import time
import sqlite3
import hashlib
from datetime import datetime


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


def getDateTimeMS(dateTime_input):
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


def test_getDateTimeMS():
    start = getDateTimeMS(datetime.now())
    time.sleep(0.01)
    print start
    assert start < getDateTimeMS(datetime.now())


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
