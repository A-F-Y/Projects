#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>

using namespace std;

// The Everglades RPG: Escape the Snake Maze
void showObjectives() {
    cout << "Everglades RPG: " << endl;
    cout << "You are trapped in a maze infested with snakes.\n";
    cout << "Your goal is to escape the maze.\n\n";
    cout << "Each move cause a snake encounter.\n";
    cout << "When encountering a snake, you can:\n";
    cout << "1.Hide (for a chance to survive)\n";
    cout << "2.Confront (risk a chance)\n\n";
    cout << "If you lose a confrontation or fail to escape the Everglades maze\n";
    cout << "before your stamina runs out you lose.\n";
    cout << "Good Luck\n";
}

bool snakeEncounter() {
    cout << "\nA snake blocked your path!" << endl;

    int choice;
    cout << "You can:\n";
    cout << "1.Hide\n";
    cout << "2.Confront\n";
    cout << "> ";
    cin >> choice;

    int roll = rand() % 100; // 0 - 99 rate

    if (choice == 1) {
        cout << "You attempted to hide...\n";
        if (roll < 70) { // 70% success rate
            cout << "You successfully hid from the snake.\n";
            return true;
        } else {
            cout << "The snake spotted you!\n";
            return false;
        }
    } 
    else if (choice == 2) {
        cout << "You confronted the snake...\n";
        if (roll < 40) { // 40% success rate
            cout << "You defeated the snake!\n";
            return true;
        } else {
            cout << "The snake overpowers you. You lose...\n";
            return false;
        }
    } 
    else {
        cout << "Invalid choice! The snake has bit you!\n";
        return false;
    }
}

void playGame() {
    int moves = 0;
    int stamina = 15; // You lose if this hits zero
    bool alive = true;

    cout << "\nESCAPE THE SNAKE MAZE\n";
    cout << "You enter the maze...\n";

    while (alive && stamina > 0) {
        moves++;
        stamina--;

        cout << "\nMove #" << moves << " " << endl;
        cout << "Stamina left: " << stamina << endl;

        int eventRoll = rand() % 100;

        if (eventRoll < 40) {
        // 40% chance for a snake encounter
            alive = snakeEncounter();
            if (!alive) break;
        } else {
            cout << "The path is clear now. You can proceed safely.\n";
        }

        // 20% chance to find the maze exit
        int escapeRoll = rand() % 100;
        if (escapeRoll < 20) {
            cout << "\nYou found the exit of the maze!\n";
            cout << "You  have escaped successfully!\n";
            cout << "Total Moves: " << moves << endl;
            cout << "Remaining Stamina: " << stamina << endl;
            return;
        }
    }

    // The If loop ends
    if (!alive) {
        cout << "\nGAME OVER You lost.\n";
    } else if (stamina <= 0) {
        cout << "\nYou collapse from exhaustion...\nGAME OVER.\n";
    }

    cout << "Moves Taken: " << moves << endl;
}

// MAIN MENU
int main() {
    srand(time(0));

    int choice;

    while (true) {
        cout << "Everglades RPG\n";
        cout << "1.Objective\n";
        cout << "2.Play Game\n";
        cout << "3.Quit Game\n";
        cout << "-----------------------\n";
        cout << "Enter a choice: ";
        cin >> choice;

        if (choice == 1) showObjectives();
        else if (choice == 2) playGame();
        else if (choice == 3) {
            cout << "Goodbye!\n";
            break;
        } 
        else {
            cout << "Invalid selection. Please try again.\n";
        }
    }

    return 0;
}
