package leetcode.p0338.dp;

class Solution {
  public int[] countBits(int n) {
    final int[] res = new int[n + 1];
    for (int i = 1; i < res.length; i <<= 1) {
      res[i] = 1;
    }

    int base = 1;
    for (int i = 1; i < res.length; i++) {
      if (res[i] == 1) {
        base = i; // 1, 2, 4, 8, 16, ...
        continue; // it doesn't affect to the result, but helps to skip redundant calculation
      }
      res[i] = res[i % base] + 1;
    }
    return res;
  }
}
