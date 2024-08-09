package edu.hw1;

public class Task2 {
    public static final int DECIMAL_BASE = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        int count = 0;
        int n = number;

        do {
            count++;
            n /= DECIMAL_BASE;
        } while (n != 0);

        return count;
    }
}
