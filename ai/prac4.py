#Breadth First Search Traversal
from collections import deque

# Define the tree as an adjacency list
def bfs(tree, start):
    visited = set()  # To keep track of visited nodes
    queue = deque([start])  # Initialize the queue with the starting node

    while queue:
        # Pop a node from the queue
        node = queue.popleft()

        if node not in visited:
            print(node, end=" ")  # Process the node
            visited.add(node)

            # Add all unvisited neighbors to the queue
            for neighbor in tree[node]:
                if neighbor not in visited:
                    queue.append(neighbor)


# Example usage
tree = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F','G'],
    'D': ['H','I'],
    'E': ['J','K'],
    'F': ['L','M'],
    'G':[],'H':[],'I':[],'J':[],
    'K':[],'L':[],'M':[],
}

print("Breadth-First Traversal starting from node A:")
bfs(tree, 'A')
