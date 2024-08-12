package edu.project1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;

public class Game {

    public static final int MIN_WORD_LENGTH = 3;
    public static final char NOT_GUESSED_CHAR = '*';
    private final String surrenderCommand;
    private final String wordToGuess;
    private final char[] guessedWord;
    private final Set<Character> incorrectGuesses;
    private int attemptsLeft;
    private boolean surrendered;

    public Game(@NotNull String wordToGuess, int maxAttempts, @NotNull String surrenderCommand) {
        if (wordToGuess.length() < MIN_WORD_LENGTH) {
            throw new IllegalArgumentException(
                "Слово должно содержать как минимум %d буквы.".formatted(MIN_WORD_LENGTH)
            );
        }
        if (surrenderCommand.isEmpty()) {
            throw new IllegalArgumentException("Команда для сдачи должна быть не пустой.");
        }

        this.wordToGuess = wordToGuess.toLowerCase();
        this.guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, NOT_GUESSED_CHAR);
        this.incorrectGuesses = new HashSet<>();
        this.attemptsLeft = maxAttempts;
        this.surrenderCommand = surrenderCommand;
        this.surrendered = false;
    }

    public boolean guess(@NotNull String input) {
        if (input.equals(surrenderCommand)) {
            this.surrendered = true;
            return true; // Игрок сдался
        }

        if (input.length() != 1) {
            return false; // Ввод должен состоять из одной буквы
        }

        char letter = Character.toLowerCase(input.charAt(0));

        if (incorrectGuesses.contains(letter) || new String(guessedWord).contains(String.valueOf(letter))) {
            return false; // Буква уже была предложена
        }

        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            incorrectGuesses.add(letter);
            attemptsLeft--;
        }

        return correctGuess;
    }

    public boolean isGameWon() {
        return new String(guessedWord).equals(wordToGuess);
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isGameWon() || surrendered;
    }

    public boolean isSurrendered() {
        return surrendered;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getGuessedWord() {
        return new String(guessedWord);
    }

    public String getSurrenderCommand() {
        return surrenderCommand;
    }

    public Set<Character> getIncorrectGuesses() {
        return new TreeSet<>(incorrectGuesses);
    }
}
