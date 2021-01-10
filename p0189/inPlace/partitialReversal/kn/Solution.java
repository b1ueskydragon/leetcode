package leetcode.p0189.inPlace.partitialReversal.kn;

class Solution {
  // O(k*n) time, O(1) space
  public void rotate(int[] nums, int k) {
    final int n = nums.length;
    k %= n;
    for (int i = 0; i < k; i++) {
      // start point
      int kth = n - k + i;
      swap(nums, i, kth);

      // tails
      int j = i + 1;
      int time = 0;
      while (time < n - k) {
        swap(nums, j, kth);
        j++;
        time++;
      }
    }
  }

  private static void swap(int[] nums,
                           int i,
                           int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
