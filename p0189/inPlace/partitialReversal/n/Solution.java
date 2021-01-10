package leetcode.p0189.inPlace.partitialReversal.n;

class Solution {
  // O(n) time, O(1) space
  public void rotate(int[] nums, int k) {
    final int n = nums.length;
    k %= n;
    // reverse all range
    reverse(nums, 0, n - 1);
    // reverse left half
    reverse(nums, 0, k - 1);
    // reverse right half
    reverse(nums, k, n - 1);
  }

  private void reverse(int[] nums,
                       int l,
                       int r) {
    while (l < r) {
      int tmp = nums[l];
      nums[l] = nums[r];
      nums[r] = tmp;
      l++;
      r--;
    }
  }
}
