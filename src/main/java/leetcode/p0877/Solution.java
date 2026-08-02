package leetcode.p0877;

class Solution {
    // sum(piles) is odd, so there are no ties.
    // Alice starting first.
    // --> Actually, Alice always wins.
    public boolean stoneGame(int[] piles) {
        // return true;

        final int n = piles.length;
        // dp[i][j] := 区間 [i, j] だけが残っている状況で, 先に打つ人が, 最後まで最適に打ち続けた結果に確保する石の合計.
        // dp[i][j] := max(
        //              piles[i] + (sum(i + 1, j) - dp[i + 1][j]),
        //              piles[j] + (sum(i, j - 1) - dp[i, j - 1])
        //             )
        final int[][] dp = new int[n][n];
        final int[] prefixSum = new int[n];
        prefixSum[0] = piles[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + piles[i];
        }
        // dp[i][j] の時点で dp[i+1][j], dp[i][j-1] を知っている必要があるから.
        // また, 常に jが i と同じ点, もしくは右にある.
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    // A single stone. Only can get that one.
                    dp[i][j] = piles[i];
                } else {
                    final int sum1 = prefixSum[j] - prefixSum[i];
                    final int section1 = piles[i] + (sum1 - dp[i + 1][j]);
                    final int sum2 = i == 0 ? prefixSum[j - 1] : prefixSum[j - 1] - prefixSum[i - 1];
                    final int section2 = piles[j] + (sum2 - dp[i][j - 1]);
                    dp[i][j] = Math.max(section1, section2);
                }
            }
        }
        final int alice = dp[0][n - 1];
        // Since eventually, all stones should be picked.
        final int bob = prefixSum[n - 1] - alice;
        return alice > bob;
    }
}
