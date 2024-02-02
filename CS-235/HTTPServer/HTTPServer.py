from socket import *
import threading
import time
import random
import os

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]
def getMessage(msg):
    item = msg.recv(1024)
    return item

def processRequest(s, addr):
    request = getMessage(s)
    request = request.decode("UTF-8")
    print(request)
    if request[:3] == "GET":
        request = request[4:]
        spaceLoc = request.find(" ")
        resource = request[:spaceLoc]
        resource = resource.strip("/")
        if resource[-4:].lower() == "html":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: text/html\n"
            response += "\n"  
            m = "404 - not found"
            try:
                infile = open(resource, "rb")
            except:
                s.send(m.encode("ascii"))
                s.close()
                exit()
            inFile = open(resource, "r")
            response += inFile.read()
            s.send(response.encode("ascii"))
        elif "greeting.ss235" in resource:
            infile = open("C:/public_html/greeting.html","rb")
            s.send(infile.read())
        elif "Vote.ss235" in resource:
            infile = open("C:/public_html/greeting.html","rb")
            s.send(infile.read())
        elif resource[-3:].lower() == "jpg":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: image/jpeg\n"
            response += "\n"
            s.send(response.encode("ascii"))
            m = "404 - not found"
            try:
                infile = open(resource, "rb")
            except:
                s.send(m.encode("ascii"))
                s.close()
                exit()
            infile = open(resource, "rb")
            s.send(infile.read())
        elif resource[-3:].lower() == "gif":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: image/gif\n"
            response += "\n"
            s.send(response.encode("ascii"))
            m = "404 - not found"
            try:
                infile = open(resource, "rb")
            except:
                s.send(m.encode("ascii"))
                s.close()
                exit()
            infile = open(resource, "rb")
            s.send(infile.read())
        elif resource[-3:].lower() == "png":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: image/png\n"
            response += "\n"
            s.send(response.encode("ascii"))
            m = "404 - not found"
            try:
                infile = open(resource, "rb")
            except:
                s.send(m.encode("ascii"))
                s.close()
                exit()
            infile = open(resource, "rb")
            s.send(infile.read())
        elif resource[-3:].lower() == "bmp":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: image/bmp\n"
            response += "\n"
            s.send(response.encode("ascii"))
            m = "404 - not found"
            try:
                infile = open(resource, "rb")
            except:
                s.send(m.encode("ascii"))
                s.close()
                exit()
            infile = open(resource, "rb")
            s.send(infile.read())
        elif resource[-3:].lower() == "ico":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: favicon/ico\n"
            response += "\n"
            s.send(response.encode("ascii"))
            infile = open(resource, "rb")
            favicon = infile.read()
            s.send(favicon)
        elif resource[-3:].lower() == "pdf":
            response = "HTTP/1.0 200 OK\n"
            response += "Content-Type: document/pdf\n"
            response += "\n"
            s.send(response.encode("ascii"))
            infile = open(resource, "rb")
            favicon = infile.read()
            s.send(favicon)
        else:
            response = "HTTP/1.0 403 Forbidden"
            response += "\n"
            response += "I'm sorry Dave, I can't do that\n"
            response += "\n"
    else:
        response = "HTTP/1.0 501 Not Implemented\n"
        response += "\n"
        response += "I'm sorry Dave, I can't do that\n"
        response += "\n"

        s.send(response.encode("ascii"))


    s.close()
    return

def HTTPServer():
    path = "C:/public_html"
    try:
        os.mkdir(path)
    except OSError:
        print("path already exists")
    else:
        os.mkdir(path)
    serversocket = socket()

    host = getIPAddress()
    print("Listening on: ", host, ":2008")
    serversocket.bind((host, 2008))

    serversocket.listen()
    VoteKumquats = 546
    VoteRutabegas = 8
    while True:
        print("Waiting for connection....")
        clientsocket, addr = serversocket.accept()
        print("Connnection from", addr)

        threading.Thread(target=processRequest, args=(clientsocket, addr)).start()

    serversocket.close()



HTTPServer()
