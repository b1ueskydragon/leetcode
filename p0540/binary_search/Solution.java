package leetcode.p0540.binary_search;

class Solution {
  // nums is a sorted array
  // consisting of only integers where every element appears exactly twice,
  // except for one element which appears exactly once.
  //
  // O(log n) time and O(1) space.
  public int singleNonDuplicate(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      final int m = l + (r - l) / 2; // left-aligned
      if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
        return nums[m];
      }
      if (nums[m - 1] == nums[m]) {
        if ((m - l) % 2 == 0) {
          // single element is on the left side
          r = m - 2;
          continue;
        }
        if ((r - m + 1) % 2 == 0) {
          // single element is on the right side
          l = m + 1;
          continue;
        }
      }
      if (nums[m] == nums[m + 1]) {
        if ((m + 1 - l) % 2 == 0) {
          // single element is on the left side
          r = m - 1;
          continue;
        }
        if ((r - m) % 2 == 0) {
          // single element is on the right side
          l = m + 2;
          continue;
        }
      }
    }
    // length 1
    return nums[l];
  }
}
