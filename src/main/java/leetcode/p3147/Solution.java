package leetcode.p3147;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        // Straightforward would be O(N^2)
        // To perform O(N), Dynamic programming.
        final int n = energy.length;
        final int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (i < k) ? energy[i] : Math.max(energy[i], dp[i - k] + energy[i]);
        }

        int ans = dp[n - 1];
        // Regardless the starting point, we must take every +k points.
        // We only can take answer from the range [n-k, n)
        for (int i = n - 1; i >= n - k; i--) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
