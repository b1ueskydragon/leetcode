package leetcode.p0712;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // dp[i][j] = s1[i:] と s2[j:] を同じにする min cost.
        // 後ろからの走査が効率的.
        // dp[i + 1][j] or dp[i][j + 1] or dp[i + 1][j + 1] が dp[i][j] に反映される.
        final int m = s1.length();
        final int n = s2.length();
        final int[][] dp = new int[m + 1][n + 1];

        // e.g.,
        // s2 = leet,
        // The very last of s1 must be "",
        // "" vs t
        // "" vs et
        // "" vs eet
        // "" vs leet
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = dp[m][j + 1] + s2.charAt(j);
        }
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] + s1.charAt(i);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    // 消す必要がないので新規 cost 上乗せせず,
                    // どちらも take over the future cost of the remaining suffixes.
                    dp[i][j] = dp[i + 1][j + 1];
                    continue;
                }
                // s1 を消す場合 + この先の cost (この j における future i)
                int reduceCost1 = s1.charAt(i) + dp[i + 1][j];
                // s2 を消す場合 + この先の cost (この i における future j)
                int reduceCost2 = s2.charAt(j) + dp[i][j + 1];
                dp[i][j] = Math.min(reduceCost1, reduceCost2);
            }
        }

        return dp[0][0];
    }
}
