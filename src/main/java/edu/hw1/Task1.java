package edu.hw1;

public class Task1 {

    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String duration) {
        int invalidValue = -1;

        if (!duration.matches("[0-9]+:[0-5][0-9]")) {
            return invalidValue;
        }

        String[] arr = duration.split(":");

        try {
            int minutes = Integer.parseInt(arr[0]);
            int seconds = Integer.parseInt(arr[1]);

            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return invalidValue;
        }
    }
}
