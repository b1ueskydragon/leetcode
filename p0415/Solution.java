package leetcode.p0415;

class Solution {
  public String addStrings(String num1, String num2) {
    int n1 = num1.length() - 1;
    int n2 = num2.length() - 1;
    final StringBuilder res = new StringBuilder();

    int cache = 0;
    while (n1 >= 0 || n2 >= 0) {
      // '0' == 48
      int x = (n1 >= 0) ? num1.charAt(n1) - 48 : 0;
      int y = (n2 >= 0) ? num2.charAt(n2) - 48 : 0;
      int acc = x + y;
      int base = (acc % 10) + cache;

      res.append(base % 10);
      // update a cache after the current base has been appended
      cache = (acc >= 10 || base >= 10) ? 1 : 0;

      n1--;
      n2--;
    }

    if (cache == 1) {
      res.append(cache);
    }

    return res.reverse().toString();
  }
}
