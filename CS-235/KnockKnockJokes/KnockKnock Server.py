from socket import *
import random
import threading
from threading import *

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

def Joke(clientsocket,addr):
    joel = open("/home/tjradke20/cs235/shared/jokes.txt")
    # joel = open("C:\\Users\Thomas\OneDrive\Desktop\jokes.txt")
    list = []
    for i in joel:
        list.append(i)
    item = random.randint(0, 52)
    joke = list[item]
    joke = joke.split(".")
    # serversocket = socket(AF_INET, SOCK_STREAM)
    # serversocket.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
    # serversocket.bind(("172.16.218.47", 2024))
    # clientsocket = socket(AF_INET, SOCK_STREAM)
    # serversocket.listen(1)
    # print("Listening on 172.16.218.47")
    # print("Waiting for connection")
    # clientsocket, addr = serversocket.accept()
    # print("connection from", addr)
    #threading.Thread(target=simpleServer(), args=(clientsocket, addr)).start()
    clientsocket.send("Knock-Knock".encode('ascii'))
    msg = clientsocket.recv(1024)
    if joke[0] == "Banana":
        yes = True
        while yes:
            clientsocket.send(joke[0].encode('ascii'))
            msg = clientsocket.recv(1024)
            response = msg.decode('ascii')
            if b"who" in msg:
                clientsocket.send("Knock-Knock".encode('ascii'))
                msg = clientsocket.recv(1024)
                continue
            elif b"WHO" in msg:
                clientsocket.send("Knock-Knock".encode('ascii'))
                msg = clientsocket.recv(1024)
                clientsocket.send(joke[1].encode('ascii'))
                msg = clientsocket.recv(1024)
                print(msg)
                clientsocket.send(joke[2].encode('ascii'))
                clientsocket.close()
                yes = False
    clientsocket.send(joke[0].encode('ascii'))
    msg = clientsocket.recv(1024)
    clientsocket.send(joke[1].encode('ascii'))
    clientsocket.close()
    #clientsocket.close()
    #serversocket.close()
def hear(clientsocket,addr):
    joel = open("/home/tjradke20/cs235/shared/jokes.txt","a")
    list = []
    for i in joel:
        list.append(i)
    item = ""
    clientsocket.send("Ok, tell me a joke.".encode('ascii'))
    msg = clientsocket.recv(1024)
    response = msg.decode('ascii')
    clientsocket.send("Who's there?".encode('ascii'))
    msg = clientsocket.recv(1024)
    response1 = msg.decode('ascii')
    item += response1 + " "
    msg1 = response1 + " who?"
    clientsocket.send(msg1.encode('ascii'))
    msg = clientsocket.recv(1024)
    response = msg.decode('ascii')
    if response1 not in response:
        clientsocket.send("protocol violation".encode('ascii'))
        clientsocket.close()
    else:
        item += response
        clientsocket.send("not funny, didn't laugh".encode('ascii'))
        clientsocket.close()
        if item not in list:
            joel.append(item)


def KnockKnock_server():
    serversocket = socket(AF_INET, SOCK_STREAM)
    serversocket.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
    serversocket.bind(("172.16.218.47", 2024))
    #clientsocket = socket(AF_INET, SOCK_STREAM)
    serversocket.listen(1)
    print("Listening on 172.16.218.47")
    while True:
        print("Waiting for connection")
        clientsocket, addr = serversocket.accept()
        print("connection from", addr)
        msg = clientsocket.recv(1024)
        if msg == b"HEAR":
            threading.Thread(target=Joke, args=(clientsocket,addr)).start()
        elif msg == b"TELL":
            threading.Thread(target=hear, args=(clientsocket,addr)).start()

KnockKnock_server()
#print(getIPAddress())

