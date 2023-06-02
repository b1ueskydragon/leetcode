package leetcode.p1909;

class Solution {
  public boolean canBeIncreasing(int[] nums) {
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (count > 1) {
        return false;
      }
      final int prev = nums[i - 1];
      final int curr = nums[i];
      // maybe curr be removed.
      if (prev >= curr) {
        count++;
        // nums[i] should be greater than nums[i-1] and also nums[i-2].
        // copy to the previous one to make compare easier on the next turn (copy instead of remove).
        // e.g. [2,4,6,8,1,7,10]
        if (i > 1 && nums[i - 2] >= curr) {
          nums[i] = nums[i - 1];
        }
      }
    }
    return count <= 1;
  }
}
