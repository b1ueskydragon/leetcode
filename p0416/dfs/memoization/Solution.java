package leetcode.p0416.dfs.memoization;

import java.util.HashMap;
import java.util.Map;

// Each of the array element will not exceed 100.
// The array size will not exceed 200.
// Containing only positive integers.
class Solution {
  // memoization. but still, the worst time might be O(2^n).
  private final Map<Integer, Boolean> isValidRoot = new HashMap<>();

  private int sumOf(int[] nums) {
    int acc = 0;
    for (int num : nums) acc += num;
    return acc;
  }

  private boolean dfs(int[] nums, int i, int targetSum) {
    // root node is the targetSum.
    if (targetSum == 0) {
      return true;
    }
    if (i == 0 || targetSum < 0) { // not found but reached to leaves. or targetSum is not positive.
      return false;
    }
    // early-return.
    if (isValidRoot.containsKey(targetSum)) return isValidRoot.get(targetSum);

    boolean isInLeft = dfs(nums, i - 1, targetSum - nums[i]);
    boolean isInRight = dfs(nums, i - 1, targetSum);
    boolean isValid = isInLeft || isInRight;

    isValidRoot.put(targetSum, isValid);

    return isValid;
  }

  public boolean canPartition(int[] nums) {
    int sum = sumOf(nums);
    if (sum % 2 != 0) return false;
    int targetSum = sum / 2;
    int last = nums.length - 1;
    return dfs(nums, last, targetSum);
  }
}
