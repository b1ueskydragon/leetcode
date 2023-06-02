package leetcode.p0070.s2021.dp.additionalSpace;

class Solution {
  public int climbStairs(int n) {
    final int[] stepsSoFar = new int[n + 1];
    stepsSoFar[0] = 1; // sentinel
    stepsSoFar[1] = 1;
    for (int i = 2; i <= n; i++) {
      stepsSoFar[i] = stepsSoFar[i - 1] + stepsSoFar[i - 2];
    }
    return stepsSoFar[n];
  }
}
