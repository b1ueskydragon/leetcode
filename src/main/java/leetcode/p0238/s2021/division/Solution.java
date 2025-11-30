package leetcode.p0238.s2021.division;

class Solution {
  // using the division op
  // O(1) space, O(N) time
  public int[] productExceptSelf(int[] nums) {
    int mult = 1;
    int zeros = 0;
    for (int num : nums) {
      if (num == 0) {
        zeros++;
        continue;
      }
      mult *= num;
    }

    for (int i = 0; i < nums.length; i++) {
      if (zeros > 1) {
        nums[i] = 0;
        continue;
      }
      if (zeros == 0) {
        nums[i] = mult / nums[i];
        continue;
      }
      nums[i] = (nums[i] == 0) ? mult : 0;
    }

    return nums;
  }
}
