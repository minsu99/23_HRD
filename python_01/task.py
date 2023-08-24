import task
@task
def mytime(ctx):
	import time
	now = time.time()
	tim_str = time.asctime(time.localtime(now))
	print("Local time is", time_str)
