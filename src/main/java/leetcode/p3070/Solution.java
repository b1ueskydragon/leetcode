package leetcode.p3070;

class Solution {
    // Must contain the top-left grid.
    public int countSubmatrices(int[][] grid, int k) {
        // e.g.,
        // given:
        // 7  2  9
        // 1  5  0
        // 2  6  6
        //
        // prefix-sum from the top-left:
        // 7  9  18
        // 8  15 24
        // 10 23 38
        //
        // Since the top-left (0, 0) must be included,
        // the number of submatrices should be same as a simple grid count.
        int count = 0;
        final int m = grid.length;
        final int n = grid[0].length;
        // Prefix sum from the top-left.
        // 1000 * 1000 * 1000 < Integer.MAX_VALUE
        int[][] prefixSum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    prefixSum[i][j] = grid[i][j];
                } else if (i == 0) {
                    prefixSum[i][j] = grid[i][j] + prefixSum[i][j - 1];
                } else if (j == 0) {
                    prefixSum[i][j] = grid[i][j] + prefixSum[i - 1][j];
                } else {
                    prefixSum[i][j] = grid[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
                }
                if (prefixSum[i][j] <= k) {
                    count++;
                }
            }
        }
        return count;
    }
}
