package leetcode.p1411;

class Solution {

    private final static int MOD = 1_000_000_007;

    // - 1行目が abc pattern (三つ全て異なる)
    //    -> 2行目は abc pattern 2通り, aba pattern 2通り
    // - 1行目が aba pattern (真ん中だけ異なる)
    //   -> 2行目は abc pattern 2通り, aba pattern 3通り
    //
    // そもそも
    // - 1行目が abc pattern なのは 6通り (場合の数が 3x2x1),
    //   1行目が aba pattern なのは 6通り (場合の数が 3x2x1)
    // 4x6 + 5x6 = 54通り

    // constraint より abc, aba しかあり得ないので
    // abc pattern を state 0, aba pattern を state 1 と定義する

    public int numOfWays(int n) {
        // dp[i][0] := i行目の abc pattern 数
        // dp[i][1] := i行目の aba pattern 数
        final int[][] dp = new int[n + 1][2];
        dp[1][0] = 6;
        dp[1][1] = 6;
        for (int i = 2; i <= n; i++) {
            // The straightforward logic before compute modulo:
            // dp[i][0] = dp[i - 1][0] * 2 + dp[i - 1][1] * 2;
            // dp[i][1] = dp[i - 1][0] * 2 + dp[i - 1][1] * 3;

            dp[i][0] = dp[i - 1][0] * 2 % MOD + dp[i - 1][1] * 2 % MOD;
            dp[i][0] %= MOD;

            // While x = MOD - 1, x * 2 is within the range of Integer, x * 3 already exceeds the range.
            // We need to split x as x * 2 % MOD + x * 1.
            // dp[i][1] = (dp[i - 1][0] * 2 % MOD + dp[i - 1][1] * 2 % MOD) % MOD + dp[i - 1][1];
            dp[i][1] = dp[i][0] + dp[i - 1][1];
            dp[i][1] %= MOD;
        }
        return (dp[n][0] + dp[n][1]) % MOD;
    }
}
