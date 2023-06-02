package leetcode.p1470.s2020;

class Solution {
  // nums.length == 2n
  public int[] shuffle(int[] nums, int n) {
    final int[] shuffled = new int[nums.length];
    int i = 0;
    int xi = 0;
    int yi = n;
    while (i < nums.length) {
      shuffled[i] = (i % 2 == 0) ? nums[xi++] : nums[yi++];
      i++;
    }
    return shuffled;
  }
}
