package leetcode.p1920.linear_space;

class Solution {
  // O(N) space.
  // The elements in nums are distinct.
  // 0 <= nums[i] < nums.length
  public int[] buildArray(int[] nums) {
    final int[] xs = new int[nums.length];
    int i = 0;
    for (int num : nums) {
      xs[i++] = nums[num];
    }
    return xs;
  }
}
