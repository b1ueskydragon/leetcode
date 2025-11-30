package leetcode.p0238.s2021.TLE;

class Solution {
  // without using the division op
  // O(k * N) time
  public int[] productExceptSelf(int[] nums) {
    final int n = nums.length;

    final int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = 1;
    }

    int k = 1;
    while (k < n) {
      for (int i = 0; i < n; i++) {
        res[i] *= nums[(i + k) % n];
      }
      k++;
    }

    return res;
  }
}
