package leetcode.p0645.inversion;

class Solution {
  // constant space
  public int[] findErrorNums(int[] nums) {
    final int[] res = new int[2];
    // nums in range 1 to n should be existed and,
    // indices in range 0 to n-1 should be existed too.
    for (int num : nums) {
      // duplicated inversion is found, since nums[num - 1] already has been inverted.
      // abs is required since the inversion (pos to neg) is in-place.
      if (nums[Math.abs(num) - 1] < 0) {
        res[0] = Math.abs(num);
        // skip this inversion (neg to pos) but continue until the end.
        continue;
      }
      nums[Math.abs(num) - 1] *= -1;
    }
    // find the element of index (i represents num-1) which has not been inverted
    for (int i = 0; i < nums.length; i++) {
      // nums[i] is still positive, it means nums[i] has not been detected in previous loop.
      if (nums[i] > 0) {
        res[1] = i + 1;
        break;
      }
    }

    return res;
  }
}
