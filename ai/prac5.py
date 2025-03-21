#Write a program to implement water jug problem
from collections import deque

def water_jug_shortest_path(capacity_x, capacity_y, target):
    """Finds the shortest path to solve the Water Jug Problem using BFS."""
    visited = set()
    queue = deque([(0, 0)])  # Initial state: both jugs empty
    parent = {}  # To store the previous state for backtracking

    while queue:
        x, y = queue.popleft()

        if (x, y) in visited:
            continue
        
        visited.add((x, y))

        if x == target or y == target:
            print("Solution found!\n")
            path = []
            while (x, y) in parent:
                path.append((x, y))
                x, y = parent[(x, y)]
            path.append((0, 0))  # Start state
            path.reverse()

            print("Steps to solution:")
            for step in path:
                print(f"Jug X: {step[0]}L, Jug Y: {step[1]}L")
            return

        # Define optimized moves (Prioritizing pouring)
        possible_moves = [
            (capacity_x, y),  # Fill Jug X
            (x, capacity_y),  # Fill Jug Y
            (0, y),  # Empty Jug X
            (x, 0),   # Empty Jug Y
            (max(0, x - (capacity_y - y)), min(capacity_y, y + x)),  # Pour X → Y
            (min(capacity_x, x + y), max(0, y - (capacity_x - x)))  # Pour Y → X
        ]
        

        for move in possible_moves:
            if move not in visited:
                queue.append(move)
                parent[move] = (x, y)  # Store the move that led here

    print("No solution possible.")

# Example Usage
jug_x = 4
jug_y = 3
target_amount = 2
water_jug_shortest_path(jug_x, jug_y, target_amount)

