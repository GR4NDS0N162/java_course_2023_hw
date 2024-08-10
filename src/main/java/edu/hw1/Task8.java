package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task8 {

    private static final int[][] OFFSETS = {
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
    };

    private Task8() {
    }

    public static boolean knightBoardCapture(int @NotNull [] @NotNull [] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (var offset : OFFSETS) {
                        int x = j + offset[0];
                        int y = i + offset[1];

                        if (y < 0 || y >= board.length || x < 0 || x >= board[y].length) {
                            continue;
                        }

                        if (board[y][x] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
