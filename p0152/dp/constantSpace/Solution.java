package leetcode.p0152.dp.constantSpace;

class Solution {
  // Assuming that result X which is the largest contiguous product from the range x.
  // a, b, c, d, [range x], w, x, y, z
  // Still, X will get bigger then current if it join at least one number if either adjacent element (d or w) is positive
  // Or it can also join two numbers if both adjacent elements are positive or negative.
  // We can expand this process until reach to both or either ends.
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int acc = 1; // contiguous product
    for (int i = 0; i < nums.length; i++) {
      acc *= nums[i];
      // current contiguous product vs max contiguous product so far
      max = Math.max(acc, max);
      // when encountered a zero, suspend and re-product from 1
      if (acc == 0) {
        acc = 1;
      }
    }

    acc = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      acc *= nums[i];
      max = Math.max(acc, max);
      if (acc == 0) {
        acc = 1;
      }
    }

    return max;
  }
}
