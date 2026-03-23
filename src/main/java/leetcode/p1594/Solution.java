package leetcode.p1594;

class Solution {
    // start(0,0), end(m-1,n-1) が決まっている. 直前までの積がわかれば OK: DP.
    // The modulo is performed after getting the maximum product.
    // (ちなみに, java's negative modulo は数学的 modulo ではなく, 符号なしで modulo してから, 符号をつけているのと同じ)
    // そもそも探索方向 →, ↓ 限定なので可能な最大値: 4^30 < Long.MAX_VALUE
    public int maxProductPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        // 探索方向 →, ↓
        // dp[i][j] = {p, n}
        // max non-negative value なので neg の場合も絶対値の大きいものを優先
        final Long[][][] dp = new Long[m][n][2];

        // 0 を positive として格納するので, 最適解が negative のみの時検出が不可能.
        // 最適解が negative のみの時, 0 が一つ以上混ざっていると最適解は必ず 0.
        boolean zeroExists = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final long v = grid[i][j];
                if (v == 0) {
                    zeroExists = true;
                }
                if (i == 0 && j == 0) {
                    if (v >= 0) {
                        dp[i][j][0] = v;
                    } else {
                        dp[i][j][1] = v;
                    }
                } else if (i == 0) {
                    // row=0 prev 左しか選択肢がないので 1D-array 埋めする.
                    final Long[] left = dp[i][j - 1];
                    if (left[0] != null) {
                        final long v2 = left[0] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = v2;
                        } else {
                            dp[i][j][1] = v2;
                        }
                    }
                    if (left[1] != null) {
                        final long v2 = left[1] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = dp[i][j][0] == null ? v2 : Math.max(dp[i][j][0], v2);
                        } else {
                            dp[i][j][1] = dp[i][j][1] == null ? v2 : Math.min(dp[i][j][1], v2);
                        }
                    }
                } else if (j == 0) {
                    // col=0 prev 上しか選択肢がないので 1D-array 埋めする.
                    final Long[] up = dp[i - 1][j];
                    if (up[0] != null) {
                        final long v2 = up[0] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = v2;
                        } else {
                            dp[i][j][1] = v2;
                        }
                    }
                    if (up[1] != null) {
                        final long v2 = up[1] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = dp[i][j][0] == null ? v2 : Math.max(dp[i][j][0], v2);
                        } else {
                            dp[i][j][1] = dp[i][j][1] == null ? v2 : Math.min(dp[i][j][1], v2);
                        }
                    }
                } else {
                    // start~end 途切れてはいけないので,
                    // 自分自身 (v) と上か下かどちらかは踏む必要がある.
                    final Long[] up = dp[i - 1][j];
                    final Long[] left = dp[i][j - 1];
                    // p * p = p
                    // n * n = p
                    // p * n = n
                    // n * p = n
                    if (up[0] != null) {
                        final long v2 = up[0] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = v2;
                        } else {
                            dp[i][j][1] = v2;
                        }
                    }
                    if (up[1] != null) {
                        final long v2 = up[1] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = dp[i][j][0] == null ? v2 : Math.max(v2, dp[i][j][0]);
                        } else {
                            // 絶対値が大きい方.
                            dp[i][j][1] = dp[i][j][1] == null ? v2 : Math.min(v2, dp[i][j][1]);
                        }
                    }
                    if (left[0] != null) {
                        final long v2 = left[0] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = dp[i][j][0] == null ? v2 : Math.max(v2, dp[i][j][0]);
                        } else {
                            dp[i][j][1] = dp[i][j][1] == null ? v2 : Math.min(v2, dp[i][j][1]);
                        }
                    }
                    if (left[1] != null) {
                        final long v2 = left[1] * v;
                        if (v2 >= 0) {
                            dp[i][j][0] = dp[i][j][0] == null ? v2 : Math.max(v2, dp[i][j][0]);
                        } else {
                            dp[i][j][1] = dp[i][j][1] == null ? v2 : Math.min(v2, dp[i][j][1]);
                        }
                    }
                }
            }
        }

        if (dp[m - 1][n - 1][0] == null) {
            return zeroExists ? 0 : -1;
        }
        return (int) (dp[m - 1][n - 1][0] % 1000000007);
    }
}
