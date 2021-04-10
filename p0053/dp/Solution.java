package leetcode.p0053.dp;

class Solution {
  // find the contiguous subarray's max sum
  public int maxSubArray(int[] nums) {
    final int[] soFar = new int[nums.length];
    soFar[0] = nums[0];
    int maxSum = soFar[0];

    for (int i = 1; i < nums.length; i++) {
      final int curr = nums[i];
      soFar[i] = Math.max(soFar[i - 1] + curr, curr);
      maxSum = Math.max(maxSum, soFar[i]);
    }

    return maxSum;
  }
}
