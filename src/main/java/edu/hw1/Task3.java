package edu.hw1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] element, int[] container) {
        return min(container) < min(element) && max(element) < max(container);
    }

    private static int min(int[] array) {
        OptionalInt min = Arrays.stream(array).min();
        return min.isPresent() ? min.getAsInt() : Integer.MAX_VALUE;
    }

    private static int max(int[] array) {
        OptionalInt max = Arrays.stream(array).max();
        return max.isPresent() ? max.getAsInt() : Integer.MIN_VALUE;
    }
}
