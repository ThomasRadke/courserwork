from socket import *

def getIPAddress():
    s = socket(AF_INET, SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

def simpleClient(location):
  #  clientip = getIPAddress()
    client = socket(AF_INET, SOCK_STREAM)
    client.connect((location, 2028))
  #  command = getIPAddress()
   # client.send(command.encode('ascii'))
    while True:
        command = input("Input command:")
        command = command.upper()
        client.send(command.encode('ascii'))
        if command == "LIST":
            while True:
                try:
                    msg = client.recv(2048)
                    if msg:
                        msg = msg.decode('ascii')
                        print(msg)
                except:
                    client.close()
                    break
            continue
        if command == "JOIN":
            room_name = input("input room name:")
            client.send(room_name.encode('ascii'))
            username = input("input username:")
            client.send(username.encode('ascii'))
            while True:
                msg = client.recv(1024)
                msg = msg.decode("ascii")
                print(msg)
                if "Denied" in msg:
                    client.close()
                    exit()
        else:
            # command = input("input command:")
            # command = command.upper()
            # client.send(command.encode('ascii'))
            if command == "EXIT":
                client.close()
                exit(simpleClient)
            elif command == "SEND":
                msg = input("input message:")
                client.send(msg.encode('ascii'))
            elif command == "WHO":
                try:
                    msg = client.recv(2048)
                    if msg:
                        msg = msg.decode('ascii')
                        print(msg)
                except:
                    client.close()
                    break
            continue
        client.close()

simpleClient("172.16.212.228")
