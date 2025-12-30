package leetcode.p0840;

class Solution {
    // Note: Small size grid based on the constraints. Brute-force is still feasible.
    public int numMagicSquaresInside(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int count = 0;
        // 3x3 grid.
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                count += magic(grid, i, j);
            }
        }
        return count;
    }

    // Start from top-left (r, c) position.
    private int magic(int[][] grid, int r, int c) {
        return hasValidSums(grid, r, c) && hasAllDigits(grid, r, c) ? 1 : 0;
    }

    private boolean hasValidSums(int[][] grid, int r, int c) {
        if (grid[r][c] + grid[r + 2][c + 2] != grid[r][c + 2] + grid[r + 2][c]) {
            return false;
        }
        if (grid[r + 1][c] + grid[r + 1][c + 2] != grid[r][c + 1] + grid[r + 2][c + 1]) {
            return false;
        }
        if (grid[r + 2][c + 2] + grid[r + 1][c + 1] != grid[r][c + 1] + grid[r][c + 2]) {
            return false;
        }
        if (grid[r][c] + grid[r + 1][c + 1] != grid[r + 2][c] + grid[r + 2][c + 1]) {
            return false;
        }
        if (grid[r + 2][c + 2] + grid[r + 1][c + 1] != grid[r + 1][c] + grid[r + 2][c]) {
            return false;
        }
        if (grid[r][c] + grid[r + 1][c + 1] != grid[r][c + 2] + grid[r + 1][c + 2]) {
            return false;
        }
        return true;
    }

    private boolean hasAllDigits(int[][] grid, int r, int c) {
        // 0 0 0 0 0 0 0 0 0 (if exists, set 1)
        // 9 8 7 6 5 4 3 2 1
        int bit = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                final int v = grid[i][j];
                if (v > 9 || v < 1) {
                    return false;
                }
                bit |= (1 << (v - 1));
            }
        }
        return bit == (1 << 9) - 1;
    }
}
