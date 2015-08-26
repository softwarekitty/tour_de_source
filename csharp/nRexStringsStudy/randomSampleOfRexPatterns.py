import random
sourcePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/analysis_output/exportedCorpusRex.txt"

#this is the number of patterns in exportedCorpusRex.txt (3582)
nPatterns = 3582
sampleSize = nPatterns/10

nSamples = 3

selectedRows = set()
with open (sourcePath, "r") as rexPatterns:
    content = rexPatterns.readlines()
    for i in range(0, nSamples):
        selectedRows.clear()
        print(len(selectedRows))
        while(len(selectedRows) < sampleSize):
            rowIndex = random.randint(0,nPatterns-1)
            selectedRows.add(content[rowIndex])
        print(len(selectedRows))
        filename = "rexSample_" + str(i) + ".txt"
        f = open(filename,"w")
        for line in selectedRows:
            f.write(line)
        f.close()
        