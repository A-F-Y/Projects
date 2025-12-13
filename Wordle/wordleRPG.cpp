//Wordle Game class
#ifndef WORDLEGAME_H
#define WORDLEGAME_H

#include <string>
using namespace std;

class WordleGame {
private:
    char** grid;
    string secretWord;
    static int currentTry;

public:
    WordleGame();
    ~WordleGame();

    void loadSecretWord();
    void play();
    void displayGrid();
    bool processGuess(const string& guess);
    void saveScore(int score);

    static int getCurrentTry();
    static void resetTry();
};

#endif

//Wordle Game Implementation
#include "WordleGame.h"
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <iomanip>

int WordleGame::currentTry = 0;
//The Constructor 
WordleGame::WordleGame() {
    grid = new char* [6];
    for (int i = 0; i < 6; i++) {
        grid[i] = new char[5];
        for (int j = 0; j < 5; j++) grid[i][j] = '_';
    }
    loadSecretWord();
    resetTry();
}
//The Destructor
WordleGame::~WordleGame() {
    for (int i = 0; i < 6; i++) delete[] grid[i];
    delete[] grid;
}
//Loads a random 5-letter word from the file txt to be the secret word in the wordle game
void WordleGame::loadSecretWord() {
    ifstream inFile("fiveLetterWords.txt");
    if (!inFile) {
        cerr << "Error can't open fiveLetterWords.txt\n";
        exit(1);
    }
    vector<string> words;
    string word;
    //Reads 5-letter words in file and stores the info
    while (getline(inFile, word)) words.push_back(word);
    //Random RNG
    srand(time(0));
    int index = rand() % words.size();
    secretWord = words[index];
}
//Displays the user's input guesses with color feedback 
void WordleGame::displayGrid() {
    for (int i = 0; i < currentTry; i++) {
        for (int j = 0; j < 5; j++) {
            char g = grid[i][j];
            if (g == secretWord[j])
                cout << "\033[32m" << g << "\033[0m"; //Green Color the letter is correct and is in the correct position of the word
            else if (secretWord.find(g) != string::npos)
                cout << "\033[33m" << g << "\033[0m"; //Yellow Color the letter is correct in the word but it's not in the correct position
            else
                cout << "\033[90m" << g << "\033[0m"; //Gray Color the letter is not in the word
        }
        cout << endl;
    }
}
//The guess inserts into the grid and try counter activates and if returned true it's correct
bool WordleGame::processGuess(const string& guess) {
    for (int i = 0; i < 5; i++) grid[currentTry][i] = guess[i];
    currentTry++;
    return guess == secretWord;
}
//The loop for the wordle game
void WordleGame::play() {
    string guess;
    cout << "\nWordle ...\n";
    while (currentTry < 6) {
        cout << "\nRound " << currentTry + 1 << " \n";
        displayGrid();
        cout << "Enter word (5-letters): ";
        cin >> guess;
        //The guess word length in this case is a 5-letter word
        if (guess.length() != 5) {
            cout << "Invalid guess length try again enter a 5-letter word.\n";
            continue;
        }
        //The user wins and has guessed correctly in 6 tries or less than 6 tries 
        if (processGuess(guess)) {
            cout << "\nMagnificent! you guessed the word in (" << currentTry << "/6) tries.\n";
            saveScore(currentTry);
            return;
        }
    }
    //Ran out of attempts the game then ends and displays the answer
    cout << "\nYou have lost game over the word was: " << secretWord << endl;
    saveScore(0);
}
//Saves the score of current game attempt
void WordleGame::saveScore(int score) {
    ofstream outFile("wordleStats.txt", ios::app);
    outFile << score << endl;
    outFile.close();
}
//Displays the amount of attempts
int WordleGame::getCurrentTry() {
    return currentTry;
}
//Resets the counter of attempts
void WordleGame::resetTry() {
    currentTry = 0;
}

//Main Program
#include <iostream>
#include "WordleGame.h"
using namespace std;
//Displays the game rules
void showRules() {
    cout << "\nWordle Game Rules: \n";
    cout << "Guess the 5-letter word in 6 tries.\n";
    cout << "After each guess you will see the colors:\n";
    cout << "Green: The letter in the correct spot\n";
    cout << "Yellow: The letter in the word but wrong spot\n";
    cout << "Gray: The letter not in the word\n";
}
//Reads the files and displays performance stats
void showPerformance() {
    ifstream file("wordleStats.txt");
    if (!file) {
        cout << "No game stats are available.\n";
        return;
    }
    int total = 0, won = 0, score, sum = 0;
    while (file >> score) {
        total++;
        if (score > 0) {
            won++;
            sum += score;
        }
    }
    file.close();

    cout << fixed << setprecision(2);
    cout << "\nGames Played: " << total << endl;
    cout << "Win Percentage: " << (total ? 100.0 * won / total : 0) << "%\n";
    cout << "Average Tries: " << (won ? (float)sum / won : 0) << endl;
}
//The program's main menu options
int main() {
    int choice;
    do {
        cout << "\nWordle Menu: \n";
        cout << "1. See Rules\n";
        cout << "2. Play Game\n";
        cout << "3. See Performance Report\n";
        cout << "4. Quit Game\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1: showRules(); break;
        case 2: {
            WordleGame game;
            game.play();
            break;
        }
        case 3: showPerformance(); break;
        case 4: cout << "Goodbye ...\n"; break;
        default: cout << "Invalid option try again.\n";
        }
    } while (choice != 4);

    return 0;
}