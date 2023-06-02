package leetcode.p0397;

class Solution {
  public int integerReplacement(int n) {
    return (n % 2 == 0) ? replaceEvenNum(n) : replaceOddNum(n);
  }

  public int replaceOddNum(long n) {
    int k = 0;
    if (n == 1) return k;
    if (n == 3) return k + 2;
    if (n == 5) return k + 3;
    if (n == 7) return k + 4;

    return Math.min(replaceEvenNum(n - 1), replaceEvenNum(n + 1)) + 1;
  }

  public int replaceEvenNum(long n) {
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
