package leetcode.p0152.dp;

class Solution {
  public int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    // set a contiguous maximum product so far (includes index i)
    // OR start over from index i (abandon the accumulate so far)
    final int[] posCache = new int[nums.length + 1];
    final int[] negCache = new int[nums.length + 1];

    // cache[i] represents the maximum contiguous product up to index i
    // OR nums[i] itself
    int i = 1;

    for (int num : nums) {
      if (num >= 0) {
        // set a product with previous value VS current value to reset
        posCache[i] = Math.max(posCache[i - 1] * num, num);
        // there's no choice but to accumulate
        negCache[i] = negCache[i - 1] * num;

      } else {
        // set a largest absolute value
        negCache[i] = Math.min(posCache[i - 1] * num, num);
        posCache[i] = negCache[i - 1] * num;

      }
      i++;
    }

    int max = 0;
    for (int pos : posCache) {
      max = Math.max(max, pos);
    }

    return max;
  }
}
