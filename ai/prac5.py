#Write a program to implement Water Jug Problem.

from collections import deque

def water_jug_bfs(x, y, z):
    # Define a function to get all possible states from the current state
    def get_next_states(state):
        a, b = state
        next_states = []

        # 1. Fill Jug A
        next_states.append((x, b))
        # 2. Fill Jug B
        next_states.append((a, y))
        # 3. Empty Jug A
        next_states.append((0, b))
        # 4. Empty Jug B
        next_states.append((a, 0))
        # 5. Pour from Jug A to Jug B
        pour_amount = min(a, y - b)
        next_states.append((a - pour_amount, b + pour_amount))
        # 6. Pour from Jug B to Jug A
        pour_amount = min(b, x - a)
        next_states.append((a + pour_amount, b - pour_amount))

        return next_states

    # BFS setup
    visited = set()  # To keep track of visited states
    queue = deque()   # Queue for BFS
    queue.append((0, 0))  # Start with both jugs empty

    while queue:
        current_state = queue.popleft()
        if current_state in visited:
            continue
        visited.add(current_state)

        a, b = current_state
        if a == z or b == z or a + b == z:
            print(f"Solution found: {current_state}")
            return True

        # Explore all next states
        for next_state in get_next_states(current_state):
            if next_state not in visited:
                queue.append(next_state)

    print("No solution exists.")
    return False

# Example usage
x = 4  # Capacity of Jug A
y = 3  # Capacity of Jug B
z = 2  # Desired amount of water
water_jug_bfs(x, y, z)
