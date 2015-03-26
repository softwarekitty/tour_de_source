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
credentials = [["KendrickMurray:kos8izjfc4dnsa", "KristinCoenen:adjutasfc4dnsA", "AllisonWheeler:Uxxy9o0QtFQGr", "SienaGarner:mW3sTB6ZpFzVlCZzYMq", "AbegailMcCreery:U676OEDBxUTogQ2Qh", "SheltonSartini:xvfkgOUubrepNtUahRs", "WallaceRobert:A6hnRe4jmU7f4qMCdXzQXy", "GeoffreyJacobs:3MgXt3BdzAgUx4iUh"], ["DenisBlackman:m4FlRnwbkH2aauI", "BentonMendel:SqrT80Jtqjuowra6LytD", "DanielMontegue:STSUv3n2ohD2NI5R55xX", "LaneWhittemore:asAuUsW53QCzZFZoq", "SimoneMatthews:E8fWrexKBld69POJ50", "MarinusBaines:AEVM6FiNOhDPrgoxUR", "RomanLandolfi:J6Qi9dmVE2RXWDoGqODCFF", "EstavanPascal:qQ20hshXEmbqIifoNKL"], ["JeromeFord:JmySeN23wRjdwlAuswFOHQ", "AshleyRobertsson:fDHfSHcxuCasAuUsW53QC", "ShamusVernon:ZGC3VCOdQWRs4D", "RubenBeverly:SFtZRtRq7ziE3C3J", "MurphyMasson:KBld69POJ50uzfeelo", "FlanaganHenderson:NKlYePPSQdAA88", "JessieHuxley:R5k9ohn8gBPPNfhT78s", "LudolfBuonarroti:HYlCH2oLbOvDMWkV"], ["CamilleMoore:Y9G1GKxRTtqGnNUBFhc", "MathewSaunders:vRT48INH52Lm4CQhab0Jjt4", "ScottHendrix:jJ67zEkBMZFCFVaIabc", "LambertBrigham:Y2tI32mUA3h4d4xo", "AmandaKeller:amkaGXEpCUmdv56SBW", "DouglasGarcia:o88ZuSq83N93OgaB6", "OliverTjoelker:E3IZ8PN52yCibHGTTetIEqiw", "AxylSaunders:38geLsPoT8Cd0q4giOBRt"]]
j = 0
totalStart = 0
chunk = 131072
for name in cloneNames:
    for i in range(0, clonesPerMachine):
        cloneSuffix = "clones/" + name + "/tour_de_source" + str(i + 1) + "/"
        basePath = LOCAL_PATH + cloneSuffix
        cred = credentials[j][i]
        first = totalStart + ((chunk * clonesPerMachine * j) + chunk * i)
        stop = totalStart + (first + chunk - 1)
        # first = 15249309
        # stop = 15249309
        newMiddlePart = 'cloneSuffix = "' + cloneSuffix + '"\ncredentials = "' + cred + '"\nfirst = ' + str(first) + '\nstop = ' + str(stop) + '\nendingMessage = "Tour of ' + cloneNames[j] + "_" + str(i+1) + ' ended with status: "\n\n'
        newMain = parts[0] + newMiddlePart + parts[2]
        fo = open(basePath + "main.py", "w")
        fo.write(newMain)
    j += 1
    exit()
print "done distributing"
