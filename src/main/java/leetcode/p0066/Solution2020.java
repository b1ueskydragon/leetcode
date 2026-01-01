package leetcode.p0066;

import java.util.Arrays;

class Solution2020 implements Solution {
  public int[] plusOne(int[] digits) {
    final int n = digits.length;
    final int[] res = new int[n];

    int d = 1;
    for (int i = n - 1; i >= 0; i--) {
      int digit = digits[i];
      if (d + digit == 10) {
        res[i] = 0;
        d = 1;
        continue;
      }
      res[i] = d + digit;
      d = 0;
    }
    if (d == 1) {
      final int[] newRes = Arrays.copyOf(res, n + 1);
      newRes[0] = 1;
      return newRes;
    }
    return res;
  }
}
