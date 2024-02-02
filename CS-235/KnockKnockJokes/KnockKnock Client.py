from socket import *
import random

def simpleClient(location):
    client = socket(AF_INET, SOCK_STREAM)
    client.connect((location, 2024))
    outgoing = input("Input HEAR or TELL")
    outgoing = outgoing.upper()
    client.send(outgoing.encode('ascii'))
    #outgoing = "Python Client: hello"
    #client.send(outgoing.encode('ascii'))
    if outgoing == "HEAR":
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)
        outgoing = "\tWho's there?"
        client.send(outgoing.encode('ascii'))
        print(outgoing)
        msg = client.recv(1024)
        response = msg.decode('ascii')
        if response == "Banana":
            yes = True
            print(response)
            while yes:
                item = random.randint(0,10)
                if item >= 1:
                    outgoing = "\t" + response + " who?"
                    client.send(outgoing.encode('ascii'))
                    print(outgoing)
                    msg = client.recv(1024)
                    response = msg.decode('ascii')
                    print(response)
                    outgoing = "\tWho's there?"
                    client.send(outgoing.encode('ascii'))
                    print(outgoing)
                    msg = client.recv(1024)
                    response = msg.decode('ascii')
                    print(response)
                elif item == 0:
                    outgoing = "\t" + response + " WHO!?"
                    client.send(outgoing.encode('ascii'))
                    print(outgoing)
                    msg = client.recv(1024)
                    response = msg.decode('ascii')
                    print(response)
                    outgoing = "\tWho's there?"
                    client.send(outgoing.encode('ascii'))
                    print(outgoing)
                    msg = client.recv(1024)
                    response = msg.decode('ascii')
                    print(response)
                    response = msg.decode('ascii')
                    outgoing = "\t" + response + " who?"
                    print(outgoing)
                    client.send(outgoing.encode('ascii'))
                    msg = client.recv(1024)
                    response = msg.decode('ascii')
                    print(response)
                    client.close()
                    yes = False
            exit()
        print(response)
        outgoing = "\t" + response + " who?"
        client.send(outgoing.encode('ascii'))
        print(outgoing)
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)
        client.close()
    elif outgoing == "TELL":
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)
        outgoing = "\tKnock-Knock"
        client.send(outgoing.encode('ascii'))
        print(outgoing)
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)
        outgoing = "\t" + input()
        client.send(outgoing.encode('ascii'))
        print(outgoing)
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)
        outgoing = "\t" + input()
        client.send(outgoing.encode('ascii'))
        print(outgoing)
        msg = client.recv(1024)
        response = msg.decode('ascii')
        print(response)

#change
simpleClient("172.16.218.47")