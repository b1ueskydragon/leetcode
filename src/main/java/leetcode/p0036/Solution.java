package leetcode.p0036;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // for (int i = 0; i < 9; i++) {
        //     System.out.print("| ");
        //     for (int j = 0; j < 9; j++) {
        //         System.out.printf("%s | ",board[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // Each row must contain the digits 1-9 without repetition
        for (int i = 0; i < 9; i++) {
            final boolean[] exists = new boolean[10];
            for (int j = 0; j < 9; j++) {
                final int value = board[i][j] - '0';
                if (value < 1) {
                    continue;
                }
                if (exists[value]) {
                    return false;
                }
                exists[value] = true;
            }
        }

        // Each column must contain the digits 1-9 without repetition
        for (int i = 0; i < 9; i++) {
            final boolean[] exists = new boolean[10];
            for (int j = 0; j < 9; j++) {
                final int value = board[j][i] - '0';
                if (value < 1) {
                    continue;
                }
                if (exists[value]) {
                    return false;
                }
                exists[value] = true;
            }
        }

        // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition
        final int[][] startingPoints = new int[][]{
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}
        };

        for (int[] pair : startingPoints) {
            final int r = pair[0];
            final int c = pair[1];
            final boolean[] exists = new boolean[10];
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    final int value = board[i][j] - '0';
                    if (value < 1) {
                        continue;
                    }
                    if (exists[value]) {
                        return false;
                    }
                    exists[value] = true;
                }
            }
        }

        // Validated
        return true;
    }
}
