package leetcode.p0415;

class Solution {
  public String addStrings(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();

    final StringBuilder sb2 = new StringBuilder(num2).reverse();
    while (n1 > n2) {
      sb2.append("0");
      n2++;
    }

    final StringBuilder sb1 = new StringBuilder(num1).reverse();
    while (n2 > n1) {
      sb1.append("0");
      n1++;
    }

    final char[] xs = sb1.toString().toCharArray();
    final char[] ys = sb2.toString().toCharArray();
    final StringBuilder res = new StringBuilder();

    int cache = 0;
    // keeping reverse order
    for (int i = 0; i < n1; i++) {
      int acc = (xs[i] + ys[i]) % 96;
      int base = ((acc >= 10) ? acc - 10 : acc) + cache;

      // set a cache after the current base has been appended
      if (base >= 10) {
        res.append(base - 10);
        cache = 1;
        continue;
      }
      res.append(base);
      cache = (acc >= 10) ? 1 : 0;
    }

    if (cache == 1) {
      res.append(cache);
    }

    return res.reverse().toString();
  }
}
