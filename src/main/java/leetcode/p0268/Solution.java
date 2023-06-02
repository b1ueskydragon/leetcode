package leetcode.p0268;

class Solution {
  // nums containing n distinct numbers in the range [0, n]
  // return the only number in the range that is missing from the array.
  //
  // Do it O(1) extra space complexity and O(n) runtime complexity.
  public int missingNumber(int[] nums) {
    final int n = nums.length;
    int res = (n + 1) * n / 2;
    for (int num : nums) {
      res -= num;
    }
    return res;
  }
}
