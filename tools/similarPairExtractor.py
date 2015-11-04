import regex
basePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source"
corpusPath = basePath + "/analysis/analysis_output/exportedCorpusRexEsc.txt"
behavioralPairsPath = basePath + "/analysis/analysis_output/behavioralSimilarityGraph.abc"

corpusMap = {}
similarRegexPairList = []
with open (corpusPath, "r") as corpusFile:
    corpus=corpusFile.readlines()
    for line in corpus:
        pair = line.split('\t')
        corpusMap[pair[0]] =pair[1]
    #for x in corpusMap:
    #    print str(x) + "," + corpusMap[x]
    r = regex.compile(r"row:(\d+)\[(\(?:(?P<col>\d+:1.00)\),?)+\]completed row")
    with open (behavioralPairsPath, "r") as behavioralFile:
        edges = behavioralFile.readlines()
        for edge in edges:
            m = regex.search(r'(\d+) (\d+) 1',edge)
            if (m):
                v1 = m.group(1)
                v2 = m.group(2)
                if (v1 != v2):
                    print v1 + "," + v2 + "\n" + corpusMap[v1] + corpusMap[v2] + "\n" 
#         #m = regex.findall(r"row:(\d+)\[\n(.*)\] completed row:.*",matrix)
#         #m = regex.search(r"(?P<nums>\d+)", mline)
#         for t in m:
#             if(t[1]):
#                 pairs = t[1].split(',')
#                 for p in pairs:
#                     vals = p[1:-1].split(':')
#                     if(vals[1] == '1.00'):
#                         print t[0] + "," + vals[0] + "\n" + corpusMap[t[0]] + "\n" + corpusMap[vals[0]] + "\n" 
        
    