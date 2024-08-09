package edu.hw2;

import edu.hw2.task1.Expr.Addition;
import edu.hw2.task1.Expr.Constant;
import edu.hw2.task1.Expr.Exponent;
import edu.hw2.task1.Expr.Multiplication;
import edu.hw2.task1.Expr.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("test1")
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
}
