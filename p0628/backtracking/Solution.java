package leetcode.p0628.backtracking;

import java.util.Arrays;

class Solution {
  public int maximumProduct(int[] nums) {
    int res = Integer.MIN_VALUE;

    if (nums.length < 6) {
      return maximumProduct(nums, 3, 0, 1, res);
    }

    Arrays.sort(nums);

    final int last = nums.length - 1;

    // top 3 abs (from right)
    final int a = nums[last];
    final int b = nums[last - 1];
    final int c = nums[last - 2];

    // top 3 abs (from left)
    final int x = nums[0];
    final int y = nums[1];
    final int z = nums[2];

    final int[] cands = {a, b, c, x, y, z};
    return maximumProduct(cands, 3, 0, 1, res);

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
      // return and make a "different" choice
      res = maximumProduct(nums, k - 1, i + 1, acc * nums[i], res);
    }
    return res;
  }
}
