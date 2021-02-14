package leetcode.p0415;

class Solution {
  public String addStrings(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();

    while (n1 > n2) {
      num2 = "0" + num2;
      n2++;
    }

    while (n2 > n1) {
      num1 = "0" + num1;
      n1++;
    }

    final char[] xs = num1.toCharArray();
    final char[] ys = num2.toCharArray();
    final StringBuilder res = new StringBuilder();

    int cache = 0;
    for (int i = n1 - 1; i >= 0; i--) {
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
