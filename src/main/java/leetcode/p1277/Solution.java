package leetcode.p1277;

class Solution {
    public int countSquares(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int[][] dp = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                // dp[i][j] := size of the largest square ending at (i, j)
                // The largest square ending  (i, j) has size k,
                // there always exist exactly one square of each size 1*1, 2*2, ..., k*k
                //
                //   1 for the cell (1*1 square) itself
                // + an extendable size from 3 neighbors (top, left, top-left)
                //
                // To form a square of size k*k ending at (i, j),
                // all 3 neighbors (top, left, top-left) must each allow at least one (k-1)*(k-1) sized square
                // Hence, dp[i][j] = 1 + min(top, left, top-left)
                final int prev = (i == 0 || j == 0) ? 0 : min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                dp[i][j] = 1 + prev;
                sum += dp[i][j];
            }
        }

        return sum;
    }

    private static int min(int x, int y, int z) {
        return Math.min(z, Math.min(x, y));
    }
}
