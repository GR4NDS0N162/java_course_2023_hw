package edu.hw1;

public final class Task4 {

    private Task4() {
    }

    public static String fixString(String string) {
        char[] chars = string.toCharArray();

        for (int i = 1; i < chars.length; i += 2) {
            var tmp = chars[i];
            chars[i] = chars[i - 1];
            chars[i - 1] = tmp;
        }

        return new String(chars);
    }
}
