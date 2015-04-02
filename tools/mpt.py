import multiprocessing as mp
import astroid as A
import resource as R
import gc

def foo():
    print "new process initial memory: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/main.py")
    print "new process after loading main.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/rewinder.py")
    print "new process after loading rewinder.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/scanner.py")
    print "new process after loading scanner.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/sourcer.py")
    print "new process after loading sourcer.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tourist.py")
    print "new process after loading tourist.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/util.py")
    print "new process after loading util.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tools/cleaner.py")
    print "new process after loading cleaner.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tools/distribute.py")
    print "new process after loading distribute.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    x = A.MANAGER.ast_from_file("/Users/carlchapman/Documents/SoftwareProjects/tour_de_source/tools/merge.py")
    print "new process after loading merge.py: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)

def trial():
    q = mp.Queue()
    p = mp.Process(target=foo)
    p.start()
    # print(q.get())
    print "original process memory: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)
    p.join()

print "starting okay"
trial()
gc.collect()
print "after joining and collecting: " + str(R.getrusage(R.RUSAGE_SELF).ru_maxrss)