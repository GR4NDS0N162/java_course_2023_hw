package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var duration = "00:00";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(0);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var duration = "00:59";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(59);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var duration = "00:34";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(34);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var duration = "00:60";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("test5")
    void test5() {
        // given
        var duration = "00:+23";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("test6")
    void test6() {
        // given
        var duration = "00:-12";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("test7")
    void test7() {
        // given
        var duration = "60:59";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(3659);
    }

    @Test
    @DisplayName("test8")
    void test8() {
        // given
        var duration = "123:59";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(7439);
    }

    @Test
    @DisplayName("test9")
    void test9() {
        // given
        var duration = "+00:00";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("test10")
    void test10() {
        // given
        var duration = "0b0:0f0";

        // when
        var seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }
}
