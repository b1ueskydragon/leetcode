package leetcode.p0665;

class Solution {
  public boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] <= nums[i + 1]) {
        continue;
      }
      if (i == 0) {
        count++;
        continue;
      }
      // adjust curr max's next value
      if (nums[i - 1] > nums[i + 1]) {
        nums[i + 1] = nums[i];
      }
      // adjust curr max's value
      else {
        nums[i] = nums[i + 1];
      }
      count++;
      if (count > 1) {
        return false;
      }
    }
    return true;
  }
}
