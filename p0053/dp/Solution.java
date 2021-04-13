package leetcode.p0053.dp;

class Solution {
  // find the contiguous subarray's max sum
  public int maxSubArray(int[] nums) {
    int prev = 0;
    int soFar = nums[0];
    int maxSum = soFar;

    for (int num : nums) {
      soFar = Math.max(prev + num, num); // always includes current num
      maxSum = Math.max(maxSum, soFar);
      prev = soFar;
    }

    return maxSum;
  }
}
