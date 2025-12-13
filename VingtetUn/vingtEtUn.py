# Vingt Et Un a python game group project

import random

# A function to display the rules of the game of Vingt-et-un.

def display_rules():
    print("The Game Rules of Vingt-et-un:")
    print("1. The goal is to score 21 points or near as possible without going over 21.")
    print("2. Players take turns throwing two dice and then it will add up the numbers to get a total rolled.")
    print("3. A player whose total is over 21 is a bust and which results the user to lose the game to the house.")
    print("4. The player closest to 21 without going over may be able to win the game.")
    print("5. If both players have the same total then the game is tied.")
    print("6. Once a player totals 14 or more then only one dice is rolled on the next turns.")
    print("7. The house must throw the dice until the total is 17 or higher and at 17 or higher the house must stay.\n")

# A function to simulate the roll of two dice used in the game.
def roll_dice(num_dice):
    return sum(random.randint(1, 6) for _ in range(num_dice))

# A function to play a round of the game of Vingt-et-un.
def play_round(player_name):
    player_total = 0
    house_total = 0

    while True:
        print(f"\n{player_name}'s turn:")
        roll_option = input("Do you want to roll or stay? (Enter 'r' to roll or 's' to stay): ").lower()

        if roll_option == 'r':
            num_dice = 2 if player_total < 14 else 1
            roll_result = roll_dice(num_dice)
            player_total += roll_result
            print(f"You rolled: {roll_result}. Your total is now: {player_total}")

            if player_total > 21:
                print("Bust! You have lost.")
                return 'Loser'
        elif roll_option == 's':
            break
        else:
            print("Invalid choice. Please enter 'r' to roll or 's' to stay.")

    # House's turn to roll must have over a roll of 17 or higher.
    while house_total < 17:
        house_total += roll_dice(2)

    print(f"\nThe House's total is: {house_total}")

    if house_total > 21 or (player_total <= 21 and player_total > house_total):
        return 'Winner'
    elif house_total == player_total:
        return 'Tie'
    else:
        return 'Loser'

# Main function the user sees when running the program to start and play the game.
def main():
    print("Welcome to the game of Vingt-et-un!")
    player_name = input("Enter your name: ")

    while True:
        print("\nMenu:")
        print("1. See the Rules of Vingt-et-un.")
        print("2. Play Vingt-et-un.")
        print("3. Quit the program.")

        choice = input("Enter your choice (1-3): ")

        if choice == '1':
            display_rules()
        elif choice == '2':
            result = play_round(player_name)
            print(f"\nResult: {result}")
        elif choice == '3':
            print("Thanks for playing Vingt-et-un. Goodbye!")
            break
        else:
            print("Invalid choice. Please enter a number between 1-3.")

if __name__ == "__main__":
    main()
