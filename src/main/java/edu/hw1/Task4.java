package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task4 {
    private Task4() {
    }

    public static String fixString(@NotNull String string) {
        var chars = string.toCharArray();

        for (int i = 1; i < chars.length; i += 2) {
            var tmp = chars[i];
            chars[i] = chars[i - 1];
            chars[i - 1] = tmp;
        }

        return new String(chars);
    }
}
