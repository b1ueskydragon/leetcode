package leetcode.p0027;

class Solution {
  // remove a val
  // Do not allocate extra space for another array.
  // The order of elements can be changed. It doesn't matter what you leave beyond the new length.
  public int removeElement(int[] nums, int val) {
    // in-place. swap to move 'removed' element to the back. or replace with the exists element.
    // [a, x, b, x, c, x, d] -> [a, b, c, d, x, x, x]
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      if (nums[i] == val && nums[j] != val) {
        nums[i] = nums[j];
        i++;
        j--;
      } else if (nums[j] == val) {
        j--;
      } else {
        i++;
      }
    }
    return i; // retrieval limit for checker.
  }
}
