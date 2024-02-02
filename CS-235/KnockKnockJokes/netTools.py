from socket import *

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

def getMessage(sock):
    data = sock.recv(1024)
    return data.decode('ascii')

def sendMessage(sock, msg):
    sock.send(msg.encode('ascii'))


### Add MockDNS Lookup here.