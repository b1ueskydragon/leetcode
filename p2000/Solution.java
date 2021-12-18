package leetcode.p2000;

class Solution {
  public String reversePrefix(String word, char ch) {
    final char[] xs = word.toCharArray();
    // find the first occurrence of ch
    for (int i = 0; i < xs.length; i++) {
      if (xs[i] == ch) {
        reverse(xs, 0, i);
        break;
      }
    }
    return new String(xs);
  }

  private static void reverse(char[] xs, int l, int r) {
    while (l <= r) {
      char tmp = xs[l];
      xs[l++] = xs[r];
      xs[r--] = tmp;
    }
  }
}
