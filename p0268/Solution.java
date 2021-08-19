package leetcode.p0268;

class Solution {
  // nums containing n distinct numbers in the range [0, n]
  // return the only number in the range that is missing from the array.
  //
  // Do it O(1) extra space complexity and O(n) runtime complexity.
  public int missingNumber(int[] nums) {
    int actualSum = 0;
    int max = 0;
    int min = 10000;
    for (int num : nums) {
      actualSum += num;
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    if (min > 0) {
      return 0;
    }
    final int expectedSum = max * (max - min + 1) / 2;
    final int diff = expectedSum - actualSum;
    return (diff > 0) ? diff : max + 1;
  }
}
