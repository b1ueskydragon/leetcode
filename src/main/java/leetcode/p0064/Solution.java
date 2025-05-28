package leetcode.p0064;

class Solution {
    // Non-negative numbers
    // Find a path from top left to bottom right
    // You can only move either down or right at any point in time
    // -> 2 dimensional DP
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] minSoFar = new int[m][n];
        minSoFar[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // Patterns
                // Note:
                // If leftToRight or upToDown can't be used, the other one might still work
                // We are finding min-sum, and hence using INT_MAX to ignore the direction that isn't possible
                final int leftToRight = (i > 0) ? minSoFar[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                final int upToDown = (j > 0) ? minSoFar[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                minSoFar[i][j] = Math.min(leftToRight, upToDown);
            }
        }
        // The result will be accumulated to the bottom right DP grid.
        return minSoFar[m - 1][n - 1];
    }
}
