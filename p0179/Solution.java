package leetcode.p0179;

import java.util.Arrays;

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 10^9
class Solution {
  // nums[i] might exceed the range of integer, but still not exceed the range of long.
  public String largestNumber(int[] nums) {
    StringBuilder res = new StringBuilder();
    int maxDigit = findMaxDigit(nums);
    long[][] dummy = new long[nums.length][2];

    int i = 0;
    for (int num : nums) {
      dummy[i][0] = num;
      dummy[i][1] = getNewNum(num, maxDigit);
      i++;
    }

    // reverse order
    Arrays.sort(dummy, (a, b) -> Long.compare(b[1], a[1]));

    for (long[] a : dummy) {
      res.append(a[0]);
    }

    return res.toString();
  }

  private int findMaxDigit(int[] nums) {
    int maxNum = 0;
    for (int num : nums) {
      maxNum = Math.max(num, maxNum);
    }
    return getDigit(maxNum);
  }

  private long getNewNum(int num, int maxDigit) {
    final int digit = getDigit(num);
    if (digit == maxDigit) {
      return num;
    }

    long last = num % 10;
    long newNum = num;
    int level = maxDigit - digit;
    for (int i = 0; i < level; i++) {
      newNum *= 10;
      newNum += last;
    }
    return newNum;
  }

  private int getDigit(int num) {
    int digit = 0;
    while (num > 0) {
      num /= 10;
      digit++;
    }
    return digit;
  }
}
