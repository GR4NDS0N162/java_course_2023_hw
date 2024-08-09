package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expr base, double pow) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), pow);
        }
    }

    record Addition(Expr l, Expr r) implements Expr {
        @Override
        public double evaluate() {
            return l.evaluate() + r.evaluate();
        }
    }

    record Multiplication(Expr l, Expr r) implements Expr {
        @Override
        public double evaluate() {
            return l.evaluate() * r.evaluate();
        }
    }
}
