package leetcode.p0238.prefixProduct;

class Solution {
  // without using the division op
  // O(N) time, using O(N) extra space only for an output array
  public int[] productExceptSelf(int[] nums) {
    final int n = nums.length;
    final int[] res = new int[n];
    res[0] = 1;

    // left to right
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    // right to left
    int acc = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= acc;
      acc *= nums[i];
    }

    return res;
  }
}
