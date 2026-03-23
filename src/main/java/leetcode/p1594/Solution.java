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
        // dp[i][j] = {max, min}.
        // {prev, neg} としてではなく {max, min} で捉えるので, 0 はどちらにも含まれ得る.
        // negative product の場合, 絶対値が大きい (符号あり値として min) 方を選んでおきたい.
        final long[][][] dp = new long[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final long v = grid[i][j];
                if (i == 0 && j == 0) {
                    dp[i][j][0] = v;
                    dp[i][j][1] = v;
                } else if (i == 0) {
                    // row=0 prev 左しか選択肢がないので 1D-array 埋めする.
                    final long[] left = dp[i][j - 1];
                    dp[i][j][0] = Math.max(left[0] * v, left[1] * v);
                    dp[i][j][1] = Math.min(left[0] * v, left[1] * v);
                } else if (j == 0) {
                    // col=0 prev 上しか選択肢がないので 1D-array 埋めする.
                    final long[] up = dp[i - 1][j];
                    dp[i][j][0] = Math.max(up[0] * v, up[1] * v);
                    dp[i][j][1] = Math.min(up[0] * v, up[1] * v);
                } else {
                    final long[] left = dp[i][j - 1];
                    final long[] up = dp[i - 1][j];
                    dp[i][j][0] = Math.max(Math.max(Math.max(left[0] * v, left[1] * v), up[0] * v), up[1] * v);
                    dp[i][j][1] = Math.min(Math.min(Math.min(left[0] * v, left[1] * v), up[0] * v), up[1] * v);
                }
            }
        }
        final long maxProduct = dp[m - 1][n - 1][0];
        return maxProduct < 0 ? -1 : (int) (maxProduct % 1000000007);
    }
}
