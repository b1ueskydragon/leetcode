package leetcode.p0397;

class Solution {
  public int integerReplacement(int n) {
    if (n == 1) return 0;
    if (n == Integer.MAX_VALUE) return 32;

    return (n % 2 == 0) ? replaceEvenNum(n) : replaceOddNum(n);
  }

  public int replaceOddNum(int n) {
    int k = 0;
    if (n == 3) return k + 2;
    if (n == 5) return k + 3;
    if (n == 7) return k + 4;

    return Math.min(replaceEvenNum(n - 1), replaceEvenNum(n + 1)) + 1;
  }

  public int replaceEvenNum(int n) {
    int k = 0;
    while (n > 1) {
      if (n % 2 != 0) {
        return k + replaceOddNum(n);
      }
      n >>= 1;
      k++;
    }
    return k;
  }
}
