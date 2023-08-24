import multiprocessing
import os

def whoami(what):
	print("process %s says: %s" % (os.getpid(), what))
	
if __name__=="__main__":
	whoami("i'm the main program")
	for n in range(4):
		p = multiprocessing.Process(target=whoami,
			args = ("i'm function %s" % n ,))
		p.start()
