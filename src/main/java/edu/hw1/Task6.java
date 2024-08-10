package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Task6 {

    public static final int KAPREKAR = 6174;
    public static final int DECIMAL_BASE = 10;
    public static final int NUMBER_DIGIT = 4;

    private Task6() {
    }

    public static int countK(int number) {
        if (number == KAPREKAR) {
            return 0;
        }

        int[] digits = new int[NUMBER_DIGIT];
        for (int i = 0, n = number; i < NUMBER_DIGIT; i++) {
            digits[i] = n % DECIMAL_BASE;
            n /= DECIMAL_BASE;
        }

        Arrays.sort(digits);

        var a = convertToInt(digits);

        for (int i = 0; i < digits.length / 2; i++) {
            var tmp = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = tmp;
        }

        var b = convertToInt(digits);

        return 1 + countK(b - a);
    }

    private static int convertToInt(int @NotNull [] digits) {
        int number = 0;
        for (var digit : digits) {
            number *= DECIMAL_BASE;
            number += digit;
        }
        return number;
    }
}
