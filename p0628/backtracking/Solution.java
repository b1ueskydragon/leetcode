package leetcode.p0628.backtracking;

class Solution {
  public int maximumProduct(int[] nums) {
    int res = Integer.MIN_VALUE; // for the array which only has negative number
    for (int num : nums) {
      if (num > 0) {
        res = 1;
        break;
      }
    }

    return maximumProduct(nums, 3, 0, 1, res);
  }

  // backtracking
  private int maximumProduct(int[] nums,
                             int k,
                             int pos,
                             int acc,
                             int res) {
    if (k == 0) {
      return Math.max(res, acc);
    }

    for (int i = pos; i < nums.length; i++) {
      // return and make a different choice
      res = maximumProduct(nums, k - 1, i + 1, acc * nums[i], res);
    }

    return res;
  }
}
