package edu.hw1;

public final class Task5 {

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        var descendant = new StringBuilder(Integer.valueOf(number).toString());

        do {
            if (isPalindrome(descendant)) {
                return true;
            }
            convertToDescendant(descendant);
        } while (descendant.length() > 1);

        return false;
    }

    private static boolean isPalindrome(StringBuilder string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static void convertToDescendant(StringBuilder stringToUpdate) {
        boolean isEvenLength = stringToUpdate.length() % 2 == 0;
        for (int i = stringToUpdate.length() - (isEvenLength ? 2 : 3); i >= 0; i -= 2) {
            int x = stringToUpdate.charAt(i) - '0';
            int y = stringToUpdate.charAt(i + 1) - '0';
            stringToUpdate.replace(i, i + 2, Integer.valueOf(x + y).toString());
        }
    }
}
