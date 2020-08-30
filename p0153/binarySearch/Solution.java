package leetcode.p0153.binarySearch;

// An array sorted in ascending order is rotated at some pivot.
// No duplicate exists in the array.
class Solution {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (nums[l] < nums[r]) return nums[l];
      if (nums[m] > nums[r]) l = m + 1;
      else r = m;
    }
    return nums[l];
  }
}
