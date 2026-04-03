package leetcode.p3418;

import java.util.Arrays;

class Solution {
    // (0, 0) ~ (m - 1, n - 1)
    // 複数の State を動的に比較 -> DP.
    public int maximumAmount(int[][] coins) {
        final int m = coins.length;
        final int n = coins[0].length;
        // DP State
        // dp[i][j] = {0 cancel so far, 1 cancels so far, 2 cancels sofar}
        final int[][][] dp = new int[m][n][3];

        // Using Integer[] requires to handle null. using int[] instead.
        // 足し算の結果が多少正確でない値も Math#max 比較で落とされていくように
        // set an unreachable min, based on the constraint.
        final int NaN = -250000001;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Since the int is primitive, using Array#fill is OK.
                Arrays.fill(dp[i][j], NaN);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = coins[i][j];
                if (i == 0 && j == 0) {
                    // 2c はまだあり得ない.
                    if (value >= 0) {
                        dp[i][j][0] = value;
                    } else {
                        dp[i][j][0] = value;
                        dp[i][j][1] = 0;
                    }

                } else if (i == 0 || j == 0) {
                    final int[] prev =
                            (i == 0) ? dp[i][j - 1] : dp[i - 1][j];
                    // 進むしかないので, ここは 1D prefix-sum.
                    if (value >= 0) {
                        // Since value is non-negative, no need to skip. Just add.
                        dp[i][j][0] = prev[0] + value;
                        dp[i][j][1] = prev[1] + value;
                        dp[i][j][2] = prev[2] + value;
                    } else {
                        // Value is negative.
                        // Current execution can be counted as the cancel count.
                        // curr 0c = (prev 0c + value)
                        // curr 1c = (prev 1c + value) OR (prev 0c and skip value)
                        // curr 2c = (prev 2c + value) OR (prev 1c and skip value)
                        dp[i][j][0] = prev[0] + value;
                        dp[i][j][1] = Math.max(prev[1] + value, prev[0]);
                        dp[i][j][2] = Math.max(prev[2] + value, prev[1]);
                    }
                } else {
                    int[] left = dp[i][j - 1];
                    int[] up = dp[i - 1][j];
                    if (value >= 0) {
                        dp[i][j][0] = Math.max(left[0], up[0]) + value;
                        dp[i][j][1] = Math.max(left[1], up[1]) + value;
                        dp[i][j][2] = Math.max(left[2], up[2]) + value;
                    } else {
                        dp[i][j][0] = Math.max(up[0], left[0]) + value;
                        dp[i][j][1] = Math.max(Math.max(up[1], left[1]) + value, Math.max(up[0], left[0]));
                        dp[i][j][2] = Math.max(Math.max(up[2], left[2]) + value, Math.max(up[1], left[1]));
                    }
                }
            }
        }

        int best = Integer.MIN_VALUE;
        for (int cand : dp[m - 1][n - 1]) {
            best = Math.max(best, cand);
        }
        return best;
    }
}
