import threading

def do_this(what):
	whoami(what)

def whoami(what):
	print("process %s says: %s" % (threading.current_thread(), what))

if __name__== "__main__":
	whoami("im the main progarm" )
	for n in range(4):
		p = threading.Thread(target=do_this, args=("I'm function %s" % n,))
		p.start()	
