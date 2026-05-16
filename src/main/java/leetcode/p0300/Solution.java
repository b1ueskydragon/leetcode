package leetcode.p0300;

class Solution {
    // 1 <= n <= 2500
    // O(n^2) time is barely feasible.
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n];
        dp[n - 1] = 1;
        // Backward DP.
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        int best = 0;
        for (int cand : dp) {
            best = Math.max(best, cand);
        }
        return best;
    }
}
