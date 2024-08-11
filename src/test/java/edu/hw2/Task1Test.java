package edu.hw2;

import edu.hw2.task1.Expr.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("1 + ((2 + 4) * (-1)) ^ 2")
    void test1() {
        // given
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four);
        var negOne = new Negate(new Constant(1));
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        // when
        var result = res.evaluate();

        // then
        assertThat(result).isEqualTo(37);
    }

    @Test
    @DisplayName("((4 + (-7)) * (-6)) ^ (2 + 4)")
    void test2() {
        // given
        var two = new Constant(2);
        var four = new Constant(4);
        var negSeven = new Negate(7);
        var add = new Addition(four, negSeven);
        var mult = new Multiplication(add, -6);
        var sumTwoFour = new Addition(two, four);
        var res = new Exponent(mult, sumTwoFour);

        // when
        var result = res.evaluate();

        // then
        assertThat(result).isEqualTo(34_012_224);
    }
}
