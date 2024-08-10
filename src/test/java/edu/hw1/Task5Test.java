package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {

    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var number = 11211230;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var number = 13001120;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var number = 23336014;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var number = 11;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }

    @Test
    @DisplayName("test5")
    void test5() {
        // given
        var number = 1;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }

    @Test
    @DisplayName("test6")
    void test6() {
        // given
        var number = 123;

        // when
        var isPalindromeDescendant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescendant).isEqualTo(true);
    }
}
