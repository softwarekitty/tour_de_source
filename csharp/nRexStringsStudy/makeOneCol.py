from os import listdir
from os.path import isfile, join
basePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/csharp/nRexStringsStudy/"

for i in range(3):
    for j in range(9):
        samplePath = basePath + "sample_" + str(i) + "/"+ str((j+1)*100) + "/"
        sampleData = []
        for k in range(18):
            folderName = str(k).zfill(2) + "/"
            folderPath = samplePath + folderName
            files = [ f for f in listdir(folderPath) if isfile(join(folderPath,f)) ]
            for file in files:
                with open (join(folderPath,file), "r") as rowData:
                    content = rowData.readlines()
                    similarities = content[4][20:-3].split(")(")
                    for cell in similarities:
                        pair = cell.split(":")
                        sampleData.append(pair[1])
        with open (samplePath + "column.txt", "w") as col:
            for data in sampleData:
                print>>col, data
