import os
from os.path import expanduser

HOME = expanduser("~")
LOCAL_PATH = HOME + "/Documents/SoftwareProjects/tour_de_source/"

# ignoreFileNames = ["merge.py", "distribute.py", "main.py", "util.py", "webappIdea.py", "clean.py"]
# ignoreFilesList = [util.BASE_PATH + g for g in ignoreFileNames]
# pythonFilesInRoot = glob.glob(util.BASE_PATH + "*.py")

# filesToDistribute = [filename for filename in pythonFilesInRoot if filename not in ignoreFilesList]


with open(LOCAL_PATH + "main.py", "r") as mainFile:
        mainString = mainFile.read()
        parts = mainString.split("# SPLIT_HERE\n")

clonesPerMachine = 8

cloneNames = ["bib", "gum", "rat", "yen"]
credentials = [["KendrickMurrayX:kos8izjfc4dnsa", "KristinCoenenX:adjutasfc4dnsA", "AllisonWheelerX:Uxxy9o0QtFQGr", "SienaGarnerX:mW3sTB6ZpFzVlCZzYMq", "AbegailMcCreeryX:U676OEDBxUTogQ2Qh", "SheltonSartiniX:xvfkgOUubrepNtUahRs", "WallaceRobertX:A6hnRe4jmU7f4qMCdXzQXy", "GeoffreyJacobsX:3MgXt3BdzAgUx4iUh"], ["DenisBlackmanX:m4FlRnwbkH2aauI", "BentonMendelX:SqrT80Jtqjuowra6LytD", "DanielMontegueX:STSUv3n2ohD2NI5R55xX", "LaneWhittemoreX:asAuUsW53QCzZFZoq", "SimoneMatthewsX:E8fWrexKBld69POJ50", "MarinusBainesX:AEVM6FiNOhDPrgoxUR", "RomanLandolfiX:J6Qi9dmVE2RXWDoGqODCFF", "EstavanPascalX:qQ20hshXEmbqIifoNKL"], ["JeromeFordX:JmySeN23wRjdwlAuswFOHQ", "AshleyRobertssonX:fDHfSHcxuCasAuUsW53QC", "ShamusVernonX:ZGC3VCOdQWRs4D", "RubenBeverlyX:SFtZRtRq7ziE3C3J", "MurphyMassonX:KBld69POJ50uzfeelo", "FlanaganHendersonX:NKlYePPSQdAA88", "JessieHuxleyX:R5k9ohn8gBPPNfhT78s", "LudolfBuonarrotiX:HYlCH2oLbOvDMWkV"], ["CamilleMooreX:Y9G1GKxRTtqGnNUBFhc", "MathewSaundersX:vRT48INH52Lm4CQhab0Jjt4", "ScottHendrixX:jJ67zEkBMZFCFVaIabc", "LambertBrighamX:Y2tI32mUA3h4d4xo", "AmandaKellerX:amkaGXEpCUmdv56SBW", "DouglasGarciaX:o88ZuSq83N93OgaB6", "OliverTjoelkerX:E3IZ8PN52yCibHGTTetIEqiw", "AxylSaundersX:38geLsPoT8Cd0q4giOBRt"]]
j = 0
totalStart = 0
chunk = 262144
for name in cloneNames:
    for i in range(0, clonesPerMachine):
        thisCloneName = cloneNames[j] + "_" + str(i + 1)
        cloneSuffix = "clones/" + name + "/tour_de_source" + str(i + 1) + "/"
        basePath = LOCAL_PATH + cloneSuffix
        cred = credentials[j][i]
        first = totalStart + ((chunk * clonesPerMachine * j) + chunk * i)
        stop = totalStart + (first + chunk - 1)
        # first = 15249309
        # stop = 15249309
        newMiddlePart = 'thisCloneName = "' + thisCloneName + '"\ncloneSuffix = "' + cloneSuffix + '"\ncredentials = "' + cred + '"\nfirst = ' + str(first) + '\nstop = ' + str(stop) + '\nendingMessage = "Tour of ' + thisCloneName + ' ended with status: "\n\n'
        newMain = parts[0] + newMiddlePart + parts[2]
        fo = open(basePath + "main.py", "w")
        fo.write(newMain)
    j += 1
print "done distributing"
