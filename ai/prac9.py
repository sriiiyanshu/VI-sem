#Tic Tac Toe game
import math

# Initialize empty board
board = [[' ' for _ in range(3)] for _ in range(3)]

def print_board():
    print()  # Add spacing before board
    for i in range(3):
        print(" " + " | ".join(board[i]))
        if i < 2:
            print("---+---+---")
    print()  # Add spacing after board

def is_winner(player):
    for i in range(3):
        if all(board[i][j] == player for j in range(3)) or \
           all(board[j][i] == player for j in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)) or \
       all(board[i][2 - i] == player for i in range(3)):
        return True
    return False

def is_draw():
    return all(cell != ' ' for row in board for cell in row)

def minimax(is_maximizing):
    if is_winner('x'):
        return 1
    elif is_winner('o'):
        return -1
    elif is_draw():
        return 0

    if is_maximizing:
        best_score = -math.inf
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'x'
                    score = minimax(False)
                    board[i][j] = ' '
                    best_score = max(best_score, score)
        return best_score
    else:
        best_score = math.inf
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'o'
                    score = minimax(True)
                    board[i][j] = ' '
                    best_score = min(best_score, score)
        return best_score

def best_move():
    best_score = -math.inf
    move = (-1, -1)
    for i in range(3):
        for j in range(3):
            if board[i][j] == ' ':
                board[i][j] = 'x'
                score = minimax(False)
                board[i][j] = ' '
                if score > best_score:
                    best_score = score
                    move = (i, j)
    return move

def main():
    print("Welcome to Tic-Tac-Toe!")
    print("You are 'o'. Computer is 'x'.")
    print("Enter your move as row and column (e.g., 1 2)")
    print_board()

    while True:
        # Player move
        try:
            row, col = map(int, input("Your move (row col): ").split())
            row -= 1
            col -= 1
            if not (0 <= row < 3 and 0 <= col < 3) or board[row][col] != ' ':
                print("Invalid move. Try again.")
                continue
        except:
            print("Invalid input. Enter two numbers between 1 and 3.")
            continue

        board[row][col] = 'o'
        print_board()

        if is_winner('o'):
            print("You win!\n")
            break
        if is_draw():
            print("It's a draw!\n")
            break

        print("Computer is making a move...\n")
        row, col = best_move()
        board[row][col] = 'x'
        print_board()

        if is_winner('x'):
            print("Computer wins!\n")
            break
        if is_draw():
            print("It's a draw!\n")
            break

if __name__ == "__main__":
    main()
