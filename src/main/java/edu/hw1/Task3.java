package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] element, int[] container) {
        return min(container) < min(element) && max(element) < max(container);
    }

    private static int min(int[] array) {
        var min = Arrays.stream(array).min();
        return min.isPresent() ? min.getAsInt() : Integer.MAX_VALUE;
    }

    private static int max(int[] array) {
        var max = Arrays.stream(array).max();
        return max.isPresent() ? max.getAsInt() : Integer.MIN_VALUE;
    }
}
