package leetcode.p3070;

class Solution {
    // Must contain the top-left grid.
    // 1000 * 1000 * 1000 < Integer.MAX_VALUE
    public int countSubmatrices(int[][] grid, int k) {
        // Prefix sum from the top-left.
        if (grid[0][0] > k) {
            // Cannot build anymore.
            return 0;
        }

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

        int count = 1; // includes (0, 0).

        final int m = grid.length;
        final int n = grid[0].length;

        int rowLimit = m - 1;
        int colLimit = n - 1;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
            if (grid[i][0] > k) {
                rowLimit = i - 1;
                break;
            }
            count++;
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
            if (grid[0][j] > k) {
                colLimit = j - 1;
                break;
            }
            count++;
        }

        for (int i = 1; i <= rowLimit; i++) {
            for (int j = 1; j <= colLimit; j++) {
                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if (grid[i][j] <= k) {
                    count++;
                }
            }
        }
        return count;
    }
}
