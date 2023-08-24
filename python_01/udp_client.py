import socket
from datetime import datetime

server_address = ('localhost', 6789)
max_size = 4096

print('Starting the client at', datetime.now())
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.sendto(b'yo d!', server_address)
data, server = client.recvfrom(max_size)
print('AT', datetime.now(), server, 'said', data)
client.close()
