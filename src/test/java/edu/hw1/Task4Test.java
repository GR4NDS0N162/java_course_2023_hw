package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var string = "123456";

        // when
        var fixed = Task4.fixString(string);

        // then
        assertThat(fixed).isEqualTo("214365");
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var string = "hTsii  s aimex dpus rtni.g";

        // when
        var fixed = Task4.fixString(string);

        // then
        assertThat(fixed).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var string = "badce";

        // when
        var fixed = Task4.fixString(string);

        // then
        assertThat(fixed).isEqualTo("abcde");
    }
}
