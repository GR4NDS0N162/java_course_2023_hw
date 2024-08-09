package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var n = 3524;

        // when
        var count = Task6.countK(n);

        // then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var n = 6621;

        // when
        var count = Task6.countK(n);

        // then
        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var n = 6554;

        // when
        var count = Task6.countK(n);

        // then
        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var n = 1234;

        // when
        var count = Task6.countK(n);

        // then
        assertThat(count).isEqualTo(3);
    }
}
