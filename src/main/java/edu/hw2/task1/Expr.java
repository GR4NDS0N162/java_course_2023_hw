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

        public Negate(double value) {
            this(new Constant(value));
        }

        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expr base, Expr pow) implements Expr {

        public Exponent(double base, double pow) {
            this(new Constant(base), new Constant(pow));
        }

        public Exponent(double base, Expr pow) {
            this(new Constant(base), pow);
        }

        public Exponent(Expr base, double pow) {
            this(base, new Constant(pow));
        }

        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), pow.evaluate());
        }
    }

    record Addition(Expr l, Expr r) implements Expr {

        public Addition(double l, double r) {
            this(new Constant(l), new Constant(r));
        }

        public Addition(double l, Expr r) {
            this(new Constant(l), r);
        }

        public Addition(Expr l, double r) {
            this(l, new Constant(r));
        }

        @Override
        public double evaluate() {
            return l.evaluate() + r.evaluate();
        }
    }

    record Multiplication(Expr l, Expr r) implements Expr {

        public Multiplication(double l, double r) {
            this(new Constant(l), new Constant(r));
        }

        public Multiplication(double l, Expr r) {
            this(new Constant(l), r);
        }

        public Multiplication(Expr l, double r) {
            this(l, new Constant(r));
        }

        @Override
        public double evaluate() {
            return l.evaluate() * r.evaluate();
        }
    }
}
