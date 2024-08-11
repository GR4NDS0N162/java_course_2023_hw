package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("test1")
    void test1() {
        // given
        Rectangle rectangle = new Rectangle(2, 4);

        // when
        var area = rectangle.area();

        // then
        assertThat(area).isEqualTo(8);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        // given
        Rectangle rectangle = new Rectangle(5, 5);
        rectangle = rectangle.setWidth(6);

        // when
        var area = rectangle.area();

        // then
        assertThat(area).isEqualTo(30);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        // given
        Rectangle rectangle = new Rectangle(5, 5);
        rectangle = rectangle.setHeight(8);

        // when
        var area = rectangle.area();

        // then
        assertThat(area).isEqualTo(40);
    }

    @Test
    @DisplayName("test4")
    void test4() {
        // given
        Rectangle rectangle = new Rectangle(5, 5);
        rectangle = rectangle.setWidth(6);
        rectangle = rectangle.setHeight(8);

        // when
        var area = rectangle.area();

        // then
        assertThat(area).isEqualTo(48);
    }

    @Test
    @DisplayName("test5")
    void test5() {
        // given
        Rectangle square = new Square(5);

        // when
        var area = square.area();

        // then
        assertThat(area).isEqualTo(25);
    }

    @Test
    @DisplayName("test6")
    void test6() {
        // given
        Rectangle square = new Square(5);
        square = square.setWidth(20);

        // when
        var area = square.area();

        // then
        assertThat(area).isEqualTo(400);
    }

    @Test
    @DisplayName("test7")
    void test7() {
        // given
        Rectangle square = new Square(5);
        square = square.setHeight(50);

        // when
        var area = square.area();

        // then
        assertThat(area).isEqualTo(2500);
    }

    @Test
    @DisplayName("test8")
    void test8() {
        // given
        Rectangle square = new Square(5);
        square = square.setWidth(50);
        square = square.setHeight(2);

        // when
        var area = square.area();

        // then
        assertThat(area).isEqualTo(4);
    }
}
