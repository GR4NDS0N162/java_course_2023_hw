package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var number = 4666;

        // when
        var count = Task2.countDigits(number);

        // then
        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var number = 544;

        // when
        var count = Task2.countDigits(number);

        // then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var number = 0;

        // when
        var count = Task2.countDigits(number);

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var number = -25;

        // when
        var count = Task2.countDigits(number);

        // then
        assertThat(count).isEqualTo(2);
    }
}
