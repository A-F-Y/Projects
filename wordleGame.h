#pragma once
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