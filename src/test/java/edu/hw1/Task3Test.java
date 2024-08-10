package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("test1")
    void test1() {
        // given
        var element = new int[] {1, 2, 3, 4};
        var container = new int[] {0, 6};

        // when
        var isNestable = Task3.isNestable(element, container);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        var element = new int[] {3, 1};
        var container = new int[] {4, 0};

        // when
        var isNestable = Task3.isNestable(element, container);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        var element = new int[] {9, 9, 8};
        var container = new int[] {8, 9};

        // when
        var isNestable = Task3.isNestable(element, container);

        // then
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        var element = new int[] {1, 2, 3, 4};
        var container = new int[] {2, 3};

        // when
        var isNestable = Task3.isNestable(element, container);

        // then
        assertThat(isNestable).isEqualTo(false);
    }
}
