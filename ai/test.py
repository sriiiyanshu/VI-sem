def water_jug_dfs(X, Y, Z):
    visited = set()
    path = []

    def dfs(a, b):
        # If state already visited, skip
        if (a, b) in visited:
            return False

        # Mark current state as visited
        visited.add((a, b))
        path.append((a, b))

        # If we have reached the goal
        if a == Z or b == Z:
            return True

        # Generate all possible next moves (states)
        next_states = [
            (X, b),     # Fill Jug A
            (a, Y),     # Fill Jug B
            (0, b),     # Empty Jug A
            (a, 0),     # Empty Jug B
            (a - min(a, Y - b), b + min(a, Y - b)),  # Pour A → B
            (a + min(b, X - a), b - min(b, X - a))   # Pour B → A
        ]

        for next_state in next_states:
            if next_state not in visited:
                if dfs(next_state[0], next_state[1]):
                    return True

        # Backtrack if this path does not lead to solution
        path.pop()
        return False

    if dfs(0, 0):
        print("Solution Path (DFS):")
        for state in path:
            print(state)
    else:
        print("No solution exists.")

# Example usage:
X = 4  # Capacity of Jug A
Y = 3  # Capacity of Jug B
Z = 2  # Target volume

water_jug_dfs(X, Y, Z)
