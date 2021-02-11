package leetcode.p0628.dp;

class Solution {
  public int maximumProduct(int[] nums) {
    int min1 = Integer.MAX_VALUE; // the smallest
    int min2 = Integer.MAX_VALUE;

    int max1 = Integer.MIN_VALUE; // the largest
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    // use '=' to get in each conditions even the elements are same
    for (int num : nums) {
      // find mins
      if (num <= min1) {
        min2 = min1;
        min1 = num;
      } else if (num <= min2) {
        min2 = num;
      }

      // find maxs
      // should be proceed simultaneously, hence no 'else'
      if (num >= max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num >= max2) {
        max3 = max2;
        max2 = num;
      }
      // find max3 only after max1 and max2 is decided
      else if (num >= max3) {
        max3 = num;
      }
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }
}
