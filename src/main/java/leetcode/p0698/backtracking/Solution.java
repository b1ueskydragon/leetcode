package leetcode.p0698.backtracking;

class Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int acc = 0;
    int max = 0;
    for (int num : nums) {
      acc += num;
      max = Math.max(num, max);
    }
    final int targetSum = acc / k;
    if (acc % k != 0 || max > targetSum) {
      return false;
    }
    return canPartitionKSubsets(nums, k, new boolean[nums.length], targetSum, 0, 0);
  }

  // backtracking
  private boolean canPartitionKSubsets(final int[] nums,
                                       final int k,
                                       final boolean[] used,
                                       final int targetSum,
                                       final int node,
                                       final int level) {
    if (k == 0) { // base case of outer recursion
      return true;
    }

    if (targetSum == node) { // base case of inner recursion
      return canPartitionKSubsets(nums, k - 1, used, targetSum, 0, 0);
    }

    for (int i = level; i < nums.length; i++) {
      final int newNode = node + nums[i];
      if (newNode > targetSum || used[i]) {
        continue;
      }
      used[i] = true;
      if (canPartitionKSubsets(nums, k, used, targetSum, newNode, level + 1)) {
        return true;
      }
      used[i] = false;
    }
    return false;
  }
}
