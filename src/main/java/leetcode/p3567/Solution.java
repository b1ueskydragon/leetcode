package leetcode.p3567;

import java.util.Arrays;

class Solution {
    // 1 <= m, n <= 30. Brute-force is OK.
    public int[][] minAbsDiff(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {

                int[] values = new int[k * k];
                int index = 0;
                // Start from (i, j) the top-left
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        values[index++] = grid[r][c];
                    }
                }

                // After sorting,
                // at least one intermediate value must exist between non-adjacent elements.
                // e.g.,
                // 線状の点 a,b,c; a <= b <= c,
                // |c - a| = (c - b) + (b - a),
                // |c - a| >= max(|c - b|, |b - a|),
                // a と c の距離は必ず途中の点との距離より小さくならない.
                // つまり最小差を持つペア候補は, ソート後の隣接ペアに限られる.
                Arrays.sort(values);
                int prev = values[0];
                ans[i][j] = Integer.MAX_VALUE;
                for (int p = 1; p < values.length; p++) {
                    int curr = values[p];
                    if (curr != prev) {
                        ans[i][j] = Math.min(ans[i][j], Math.abs(prev - curr));
                    }
                    prev = curr;
                }
                if (ans[i][j] == Integer.MAX_VALUE) {
                    ans[i][j] = 0;
                }
            }
        }

        return ans;
    }
}
