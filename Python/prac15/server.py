import socket

# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Get local machine name and bind the socket to it
host = 'localhost'
port = 12345
server_socket.bind((host, port))

# Start listening for incoming connections
server_socket.listen(5)
print(f"Server listening on {host}:{port}")

while True:
    client_socket, addr = server_socket.accept()
    print(f"Got connection from {addr}")
    
    # Receive data from client
    data = client_socket.recv(1024).decode()
    print(f"Received from client: {data}")
    
    # Send response back to client
    response = f"Server received: {data}"
    client_socket.send(response.encode())

    client_socket.close()
