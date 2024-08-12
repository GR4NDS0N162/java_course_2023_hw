package edu.project1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game("java", 5, "!");
    }

    @Test
    @DisplayName("Проверка правильного угадывания буквы")
    public void testCorrectGuess() {
        boolean result = game.guess("j");
        assertThat(result).isTrue();
        assertThat(game.getGuessedWord()).isEqualTo("j***");
    }

    @Test
    @DisplayName("Проверка неправильного угадывания буквы")
    public void testIncorrectGuess() {
        boolean result = game.guess("z");
        assertThat(result).isFalse();
        assertThat(game.getIncorrectGuesses()).contains('z');
        assertThat(game.getAttemptsLeft()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка условий победы")
    public void testWinCondition() {
        game.guess("j");
        game.guess("a");
        game.guess("v");
        game.guess("a");
        assertThat(game.isGameWon()).isTrue();
    }

    @Test
    @DisplayName("Проверка условий поражения")
    public void testLoseCondition() {
        game.guess("z");
        game.guess("x");
        game.guess("q");
        game.guess("w");
        game.guess("e");
        assertThat(game.isGameOver()).isTrue();
        assertThat(game.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("Проверка повторного ввода одной и той же буквы")
    public void testAlreadyGuessedLetter() {
        game.guess("j");
        boolean result = game.guess("j");
        assertThat(result).isFalse();
        assertThat(game.getAttemptsLeft()).isEqualTo(5);
    }

    @Test
    @DisplayName("Проверка сдачи игроком")
    public void testSurrender() {
        game.guess("!");
        assertThat(game.isGameOver()).isTrue();
        assertThat(game.isSurrendered()).isTrue();
    }

    @Test
    @DisplayName("Проверка исключения при слове длиной меньше минимального")
    public void testInvalidWordLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Game("ja", 5, "!");
        });
        assertThat(exception.getMessage()).isEqualTo("Слово должно содержать как минимум %d буквы.".formatted(Game.MIN_WORD_LENGTH));
    }

    @Test
    @DisplayName("Проверка исключения при пустой команде для сдачи")
    public void testInvalidSurrenderCommandLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Game("java", 5, "");
        });
        assertThat(exception.getMessage()).isEqualTo("Команда для сдачи должна быть не пустой.");
    }

    @Test
    @DisplayName("Проверка поражения после превышения максимального количества попыток")
    public void testExceedMaxAttemptsResultsInLoss() {
        game.guess("z");
        game.guess("x");
        game.guess("q");
        game.guess("w");
        game.guess("e");
        assertThat(game.isGameOver()).isTrue();
        assertThat(game.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("Проверка корректности изменения состояния игры при угадывании/не угадывании")
    public void testGameStateAfterGuess() {
        game.guess("j");
        assertThat(game.getGuessedWord()).isEqualTo("j***");
        assertThat(game.getAttemptsLeft()).isEqualTo(5);

        game.guess("z");
        assertThat(game.getIncorrectGuesses()).contains('z');
        assertThat(game.getAttemptsLeft()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка, что ввод строки длиной больше одной буквы не меняет состояние игры")
    public void testInvalidInput() {
        boolean result = game.guess("zz");
        assertThat(result).isFalse();
        assertThat(game.getGuessedWord()).isEqualTo("****");
        assertThat(game.getAttemptsLeft()).isEqualTo(5);
    }
}
