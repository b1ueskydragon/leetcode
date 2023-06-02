package leetcode.p0643.slidingWindow;

// find the contiguous subarray of given length k that has the maximum average value
class Solution {
  // O(N) time, O(1) space
  public double findMaxAverage(int[] nums, int k) {
    double maxSum = 0;
    int i = 0;
    while (i < k) {
      maxSum += nums[i++];
    }
    double candidate = maxSum;

    for (int j = k; j < nums.length; j++) {
      candidate = candidate + nums[j] - nums[j - k];
      maxSum = Math.max(maxSum, candidate);
    }

    return maxSum / k;
  }
}
