import time
import paho.mqtt.client as paho
from gpiozero import LED

broker = "172.16.212.228:2008"
broker = "test.mosquitto.org"

def onMessage(client, userdata, message):
    led = LED(17)
    time.sleep(1)
    msg = str(message.payload.decode("utf-8"))
    print(type(msg))
    print(msg)
    print(repr(msg))
    msg = msg.strip('\n')
    if msg == "state=on":
        led.on()
    elif msg == "state=off":
        led.off()
   # else:
        #print(msg)


def onConnect(client, userdata, flags, rc):
    print("Connecting")
    if rc == 0:
        print("Connect Ok")
    else:
        print("Bad Connection")
# def onPublish(client, userdata, result)

def mqttConnection():
    client = paho.Client("Hughes")
    client.on_message = onMessage
    client.on_connect = onConnect

    print("connecting to broker", broker)
    client.connect(broker)  # connect
    client.loop_start()
    client.subscribe("sbhtest")
    client.publish("sbhtest", "PythonClient")  # publish
    while (True):
        time.sleep(4)

    client.loop_stop()

    return client

mqttConnection()