package leetcode.p1399.dp;

class Solution {
  public int countLargestGroup(int n) {
    if (n < 10) {
      return n;
    }
    // index is digitsum, value is count.
    // constraints: 1<=n<=10000, max digitsum is 9*4
    // 0th is a sentinel.
    final int[] table = new int[37];

    for (int x = 0; x <= n; x++) {
      table[digitSum(x)] += 1;
    }

    int max = 0;
    int count = 0;

    for (int cand : table) {
      if (cand > max) {
        max = cand;
        count = 1;
        continue;
      }
      if (cand == max) {
        count++;
      }
    }

    return count;
  }

  private int digitSum(final int n) {
    int acc = 0;
    int x = n;

    while (x > 0) {
      acc = acc + x % 10;
      x /= 10;
    }

    return acc;
  }
}
