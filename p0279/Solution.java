package leetcode.p0279;

import java.util.Arrays;

class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1); // instead of Inf to prevent overflow.
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // just plus 1. it's dp[j * j].
      }
    }
    return dp[n];
  }
}
