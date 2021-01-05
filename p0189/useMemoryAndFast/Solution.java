package leetcode.p0189.useMemoryAndFast;

class Solution {
  public void rotate(int[] nums, int k) {
    final int n = nums.length;
    if (k >= n) {
      k = k % n;
    }
    if (k == 0) {
      return;
    }
    // use additional memory and fast
    final int[] backup = new int[n - k];
    for (int i = 0; i < n - k; i++) {
      backup[i] = nums[i];
    }
    for (int i = n - k; i < n; i++) {
      nums[i - n + k] = nums[i];
    }
    for (int i = 0; i < n - k; i++) {
      nums[i + k] = backup[i];
    }
  }
}
