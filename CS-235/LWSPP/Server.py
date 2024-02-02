from socket import *
import threading
import time
import random

class roominfo:
    dic = {"Test":[]}

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

def getMessage(msg):
    item = msg.recv(1024)
    return item

def processRequest(s, addr):
   # IP = getMessage(s)
    while True:
        request = getMessage(s)
        request = request.upper()
        request = request.decode('ascii')
        if request == "JOIN":
            room_name = getMessage(s)
            room_name = room_name.decode('ascii')
            username = getMessage(s)
            username = username.decode('ascii')
            if room_name not in roominfo.dic.keys():
                msg = "OK \t" + room_name + "created"
                s.send(msg.encode('ascii'))
                listd = [addr,username,s]
                roominfo.dic[room_name] = [tuple(listd)]
            elif room_name in roominfo.dic.keys():
                if username in roominfo.dic[room_name]:
                    msg = "Denied \t username not unique"
                    s.send(msg.encode('ascii'))
                    s.close()
                else:
                    msg = "OK \t joined" + room_name
                    s.send(msg.encode('ascii'))
                    listd = [addr, username, s]
                    roominfo.dic[room_name].append(tuple(listd))
                    exit()
        if request == "LIST":
            msg = roominfo.dic.keys()
            for i in msg:
                s.send(i.encode('ascii'))
            s.close()
        else:
            inroom = False
            for key in roominfo.dic:
                if addr[0] in roominfo.dic[key][0][0][0]:
                    room_name = key
                    username = roominfo.dic[key][0][1]
                    inroom = True
                    break
            if inroom == False:
                msg = 'invalid IP'
                s.send(msg.encode('ascii'))
                s.close()
        # msg = getMessage(s)
        # msg = msg.upper()
        # msg = msg.decode('ascii')
        if request == "EXIT":
            print("LEFT" + "\t", username)
            roominfo.dic[room_name].remove(username)
            s.close()
            if roominfo.dic[room_name] == []:
                roominfo.dic.pop(room_name)
                exit()
        if request == "SEND":
            item = getMessage(s)
            item = item.decode('ascii')
            fl = "SENT" + "\t" + username + "\t" + item
            for i in roominfo.dic[room_name]:
                i = i[0][2]
                print(i)
                i.send(fl.encode('ascii'))
            print("SENT" + "\t" + username + "\t" + item)
        if request == "WHO":
            msg = roominfo.dic[room_name]
            for i in msg:
                s.send(i[1].encode('ascii'))






    s.close()

def HTTPServer():
    serversocket = socket()

    host = getIPAddress()
    print("Listening on: ", host, ":2028")
    serversocket.bind((host, 2028))

    serversocket.listen()

    while True:
        clientsocket, addr = serversocket.accept()

        threading.Thread(target=processRequest, args=(clientsocket, addr)).start()



HTTPServer()