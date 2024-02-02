from socket import *


def HTTPClient(ip, resource):
    s = socket()
    s.connect((ip, 2008))
    msg = "GET " + resource + " HTTP/1.1\r\n"
    msg += "Host:" + ip + "\r\n"
    msg += "\r\n"
    msg = msg.encode("ascii")

    s.send(msg)
    response = s.recv(8192)
    response2 = s.recv(8192)

    s.close()
    print(response)
    print(response2)
    loc = response.find(b"\r\n\r\n")
    msg = response[loc+4:]
    outfile = open("test.html", "wb")
    outfile.write(msg)
    outfile.close()
    
    
    #page = response.decode("ascii")
    #print(page)

HTTPClient("172.16.212.228", "greeting.ss235")
