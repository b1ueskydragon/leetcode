package leetcode.p3643;

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        // Sum of ends.
        // e.g,
        // when k = 4
        // case x = 0, flip row=0 and row=3, row=1 and row=2
        // case x = 1, flip row=1 and row=4, row=2 and row=3
        // case x = 2, flip row=2 and row=5, row=3 and row=4
        // ...
        final int sum = x + (x + k - 1);
        for (int i = x; i < x + (k / 2); i++) {
            for (int j = y; j < y + k; j++) {
                int tmp = grid[sum - i][j];
                grid[sum - i][j] = grid[i][j];
                grid[i][j] = tmp;
            }
        }
        return grid;
    }
}
