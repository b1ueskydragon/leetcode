package leetcode.p0205.array.allAscii;

// Isomorphic Strings
class Solution {
  // t.length == s.length.
  // s and t consist of any valid ascii character.
  public boolean isIsomorphic(String s, String t) {
    // these additional arrays spend at most 1024 byte (space).
    final int[] xRange = new int[256];
    final int[] yRange = new int[256];
    final char[] xs = s.toCharArray();
    final char[] ys = t.toCharArray();

    for (int i = 0; i < xs.length; i++) {
      int x = xs[i];
      int y = ys[i];
      if (xRange[x] == 0) {
        xRange[x] = y;
      }
      if (yRange[y] == 0) {
        yRange[y] = x;
      }
      if (xRange[x] != y || yRange[y] != x) {
        return false;
      }
    }
    return true;
  }
}
