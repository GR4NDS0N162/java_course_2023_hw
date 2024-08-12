package edu.project1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> dictionary = List.of("java", "python", "hangman", "code");
        WordDictionary wordDictionary = new WordDictionary(dictionary);
        String wordToGuess = wordDictionary.getRandomWord();

        Game game = new Game(wordToGuess, 5, "!");
        HangmanConsole console = new HangmanConsole(game);
        console.start();
    }
}
