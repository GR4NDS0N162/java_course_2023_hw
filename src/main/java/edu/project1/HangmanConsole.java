package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HangmanConsole {

    private final static Logger LOGGER = LogManager.getLogger();

    private final Game game;

    public HangmanConsole(Game game) {
        this.game = game;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Добро пожаловать в игру Виселица!");
        LOGGER.info("Для сдачи введите: {}", game.getSurrenderCommand());

        while (!game.isGameOver()) {
            LOGGER.info("Текущее слово: {}", game.getGuessedWord());
            LOGGER.info("Ошибочные буквы: {}", game.getIncorrectGuesses());
            LOGGER.info("Осталось попыток: {}", game.getAttemptsLeft());
            LOGGER.info("Введите букву: ");
            String input = scanner.nextLine().trim();

            if (!game.guess(input)) {
                if (input.length() != 1) {
                    LOGGER.info("Ошибка: введите одну букву.");
                } else {
                    LOGGER.info("Неправильная буква!");
                }
            }

            if (game.isGameWon()) {
                LOGGER.info("Вы выиграли! Слово: {}", game.getGuessedWord());
            } else if (game.isSurrendered()) {
                LOGGER.info("Вы сдались. Слово было: {}", game.getGuessedWord());
            }
        }

        if (!game.isGameWon() && !game.isSurrendered()) {
            LOGGER.info("Вы проиграли! Слово было: {}", game.getGuessedWord());
        }

        scanner.close();
    }
}
