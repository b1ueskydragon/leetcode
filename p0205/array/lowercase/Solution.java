package leetcode.p0205.array.lowercase;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    final int n = s.length();
    // only targeting a lowercase
    final char[] xRange = new char[26];
    final char[] yRange = new char[26];

    final char[] S = s.toCharArray();
    final char[] T = t.toCharArray();

    for (int i = 0; i < n; i++) {
      char x = S[i], y = T[i];
      if (xRange[x % 97] == 0 && yRange[y % 97] == 0) {
        xRange[x % 97] = y;
        yRange[y % 97] = x;
      } else if (xRange[x % 97] != y || yRange[y % 97] != x) {
        return false;
      }
    }

    return true;
  }
}
