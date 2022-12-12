package leetcode.p0070.s2021.dp.constantSpace;

class Solution {
  public int climbStairs(int n) {
    int prevOneStep = 1;
    int prevTwoSteps = 1;
    int soFar = 1;

    for (int i = 2; i <= n; i++) {
      soFar = prevOneStep + prevTwoSteps;
      prevTwoSteps = prevOneStep;
      prevOneStep = soFar;
    }
    return soFar;
  }
}
