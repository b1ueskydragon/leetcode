package leetcode.p1480;

class Solution {
  public int[] runningSum(int[] nums) {
    final int[] folded = new int[nums.length];
    folded[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      folded[i] = nums[i] + folded[i - 1];
    }
    return folded;
  }
}
