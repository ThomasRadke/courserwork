from socket import *

class connectionerror(Exception):
    pass

def getHostName():
    import socket
    addr = socket.gethostname()
    return addr

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

def DNSclient(Server):
    addr = getHostName()
    ip = getIPAddress()
    let = addr + "," + ip
    print(let)
    client = socket(AF_INET, SOCK_STREAM)
    client.connect((Server,2001))
    client.send(let.encode('ascii'))
    msg1 = client.recv(1024)
    if msg2 == "ok:unsafe":
        raise connectionerror("unsafe IP")
    item = input()
    client.send(item.encode('ascii'))
    item = item.split
    if item[1] == "ok":
        client.close()
    elif item[1] == "who":
        msg2 = client.recv(1024)
        return msg2
    return

DNSclient("cs235.ddns.net:2001")