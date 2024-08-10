package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {

    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var n = 8;
        var shift = 1;

        // when
        var result = Task7.rotateRight(n, shift);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var n = 16;
        var shift = 1;

        // when
        var result = Task7.rotateLeft(n, shift);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var n = 17;
        var shift = 2;

        // when
        var result = Task7.rotateLeft(n, shift);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var n = 42;
        var shift = 10;

        // when
        var result = Task7.rotateLeft(n, shift);

        // then
        assertThat(result).isEqualTo(42);
    }

    @Test
    @DisplayName("test5")
    void test5() {
        // given
        var n = 42;
        var shift = 10;

        // when
        int result = Task7.rotateRight(n, shift);

        // then
        assertThat(result).isEqualTo(42);
    }
}
