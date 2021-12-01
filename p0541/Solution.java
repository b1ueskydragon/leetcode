package leetcode.p0541;

class Solution {
  public String reverseStr(String s, int k) {
    if (k < 2) {
      return s;
    }
    final char[] xs = s.toCharArray();
    final int n = xs.length;
    int i = 0;
    // Calculate a section and jump to the next.
    while (i < n) {
      int t = i + k - 1;
      int j = (t >= n) ? n - 1 : t;
      reverse(xs, i, j);
      i += 2 * k;
    }
    return String.valueOf(xs);
  }
  // Two pointers.
  private static void reverse(char[] xs, int l, int r) {
    while (l < r) {
      char tmp = xs[l];
      xs[l] = xs[r];
      xs[r] = tmp;
      l++; r--;
    }
  }
}
