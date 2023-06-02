package leetcode.p0167;

class Solution {
  // sorted in ascending order.
  // not zero-based index.
  // ach input would have exactly one solution and you may not use the same element twice.
  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;
    final int[] res = new int[2];
    while (l < r) {
      final int curr = numbers[l] + numbers[r];
      if (curr == target) {
        res[0] = l + 1;
        res[1] = r + 1;
        return res;
      }
      if (curr < target) {
        l++;
        continue;
      }
      if (curr > target) {
        r--;
        continue;
      }
    }
    return res;
  }
}
