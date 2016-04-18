x = set()
sourcePath = "/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/analysis/behavioral_clustering/behavioralSimilarityGraph.abc"
with open (sourcePath, "r") as edges:
    content = edges.readlines()
    for edge in content:
    	print edge
        els = edge.split()
        x.add(els[0])
        x.add(els[1])
print(len(x))
        