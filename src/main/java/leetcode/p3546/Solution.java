package leetcode.p3546;

class Solution {
    // Integer.MAX_VALUE < 100000 * 100000 * 100000 < Long.MAX_VALUE
    public boolean canPartitionGrid(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        // sum: row-major order
        final long[] rows = new long[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final long v = grid[i][j] * 1L;
                rows[i] += v;
            }
        }
        // sum: column-major order
        final long[] cols = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                final long v = grid[i][j] * 1L;
                cols[j] += v;
            }
        }
        return canDivide(rows) || canDivide(cols);
    }

    // e.g.,
    // xs = [8, 4, 4]
    // prefix-sum = [8, 12, 16]
    // suffix-sum = [16, 8, 4]
    // →
    //   <8> |  12  16
    //   16  |  <8>  4
    //                 ←
    // Divisible from the index between 0 and 1.
    private boolean canDivide(long[] xs) {
        final int n = xs.length;
        final long[] prefixSum = new long[n];
        final long[] suffixSum = new long[n];
        prefixSum[0] = xs[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + xs[i];
        }
        suffixSum[n - 1] = xs[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + xs[i];
        }

        for (int i = 0; i < n; i++) {
            if ((i < n - 1 && prefixSum[i] == suffixSum[i + 1])
                || (i > 0 && prefixSum[i - 1] == suffixSum[i])) {
                return true;
            }
        }
        return false;
    }
}
