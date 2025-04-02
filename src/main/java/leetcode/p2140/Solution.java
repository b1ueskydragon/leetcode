package leetcode.p2140;

class Solution {
    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        // dp[i] := an accumulated, `proper` result AFTER i th index (i included).
        // Indices before i only `use` the result. They don't care what exactly chose at i th.
        long[] dp = new long[n];
        // Important:
        // Start from the last element - it has no future dependency.
        // There are no further elements to consider after the last one.
        // Its value depends solely on whether we solve it or skip it.
        for (int i = n - 1; i >= 0; i--) {
            final int[] pair = questions[i];
            final int value = pair[0];
            final int skip = pair[1] + 1;
            final long inclCurr = (i + skip < n) ? value + dp[i + skip] : value;
            // Simply take over the past (at this problem it is next) result.
            // We don't need to care what dp[i+1] chose before. Just use its result.
            final long exclCurr = (i + 1 < n) ? dp[i + 1] : 0;
            dp[i] = Math.max(inclCurr, exclCurr);
        }

        return dp[0];
    }
}
