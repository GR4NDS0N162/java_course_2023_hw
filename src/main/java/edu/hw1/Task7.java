package edu.hw1;

import java.util.BitSet;

public class Task7 {
    private static final int BINARY_BASE = 2;

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        return rotate(n, shift);
    }

    private static int rotate(int number, int shiftToLeft) {
        var bitSet = new BitSet(Integer.SIZE);
        for (int i = 0, n = number; n > 0; i++) {
            bitSet.set(i, n % BINARY_BASE != 0);
            n /= BINARY_BASE;
        }

        int result = 0;

        var length = bitSet.length();
        var finalShiftToLeft = shiftToLeft % length;
        for (int i = 0; i < length; i++) {
            if (bitSet.get(i)) {
                var newIndex = (i + finalShiftToLeft + length) % length;
                result |= 0x1 << newIndex;
            }
        }

        return result;
    }

    public static int rotateRight(int n, int shift) {
        return rotate(n, -shift);
    }
}
