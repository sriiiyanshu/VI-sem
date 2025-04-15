import socket

# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the server
host = 'localhost'
port = 12345
client_socket.connect((host, port))

# Send a message to the server
message = "Hello from the client!"
client_socket.send(message.encode())

# Receive response from the server
response = client_socket.recv(1024).decode()
print(f"Received from server: {response}")

client_socket.close()
