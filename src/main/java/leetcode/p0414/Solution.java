package leetcode.p0414;

class Solution {
  // O(N) time and O(1) space.
  public int thirdMax(int[] nums) {
    int first = Integer.MIN_VALUE;
    int second = first;
    int third = first;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num < min) {
        min = num;
      }
      if (num > first) {
        third = second;
        second = first;
        first = num;
        continue;
      }
      if (num > second) {
        if (num != first) third = second;
        if (num != first) second = num;
        continue;
      }
      if (num > third) {
        if (num != second) third = num;
      }
    }
    if (nums.length < 3 || first == second || second == third || third < min) {
      return first;
    }
    return third;
  }
}
