package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("test1")
    void test1() {
        // given

        // when
        var callingInfo = Task4.callingInfo();

        // then
        assertThat(callingInfo).isEqualTo(new CallingInfo("edu.hw2.Task4Test", "test1"));
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given

        // when
        var callingInfo = Task4.callingInfo();

        // then
        assertThat(callingInfo).isEqualTo(new CallingInfo("edu.hw2.Task4Test", "test2"));
    }
}
