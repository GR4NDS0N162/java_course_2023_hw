package edu.project1;

import java.util.Scanner;

public class HangmanConsole {

    private final Game game;

    public HangmanConsole(Game game) {
        this.game = game;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Для сдачи введите: " + game.getSurrenderCommand());

        while (!game.isGameOver()) {
            System.out.println("Текущее слово: " + game.getGuessedWord());
            System.out.println("Ошибочные буквы: " + game.getIncorrectGuesses());
            System.out.println("Осталось попыток: " + game.getAttemptsLeft());
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim();

            if (!game.guess(input)) {
                if (input.length() != 1) {
                    System.out.println("Ошибка: введите одну букву.");
                } else {
                    System.out.println("Неправильная буква!");
                }
            }

            if (game.isGameWon()) {
                System.out.println("Вы выиграли! Слово: " + game.getGuessedWord());
            } else if (game.isSurrendered()) {
                System.out.println("Вы сдались. Слово было: " + game.getGuessedWord());
            }
        }

        if (!game.isGameWon() && !game.isSurrendered()) {
            System.out.println("Вы проиграли! Слово было: " + game.getGuessedWord());
        }

        scanner.close();
    }
}
