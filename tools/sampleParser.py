import astroid
 
sampleFilePath = '''/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tools/sampleProject/sampleProject.py'''
fList = ["re.compile", "re.search", "re.match", "re.split", "re.findall", "re.finditer", "re.sub", "re.subn"]

def extractRegexR(child):
   from astroid import node_classes, scoped_nodes, bases
   # all the methods we will look for
   target_func = fList
   if isinstance(child, node_classes.CallFunc) and child.func.as_string() in target_func:
       print("found targedFunction: " + str(child.func.as_string()))
   for grandchild in child.get_children():
       extractRegexR(grandchild)

 
node = astroid.manager.AstroidManager().ast_from_file(sampleFilePath)
extractRegexR(node)


