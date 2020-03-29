import json
import psutil
import time
from twisted.internet import task, reactor

append_resource_util_summary_time = 1 #s

def append_resource_util_summary():
    current_milis = int(round(time.time() * 1000))
    info = json.dumps({"milis": current_milis, "cpu": psutil.cpu_percent(), "memory": psutil.virtual_memory().percent})
    open("resource-util.txt", "a+").write(info+"\n")
    pass

append_resource_util_summary_task = task.LoopingCall(append_resource_util_summary)
append_resource_util_summary_task.start(append_resource_util_summary_time)

reactor.run()
