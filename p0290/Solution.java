package leetcode.p0290;

import java.util.HashSet;
import java.util.Set;

class Solution {
  // You may assume pattern contains only lowercase letters,
  // and str contains lowercase letters that may be separated by a single space.
  public boolean wordPattern(String pattern, String str) {
    if (pattern == null || pattern.length() == 0) {
      return false;
    }
    final String[] yRange = str.split(" ");
    final char[] xRange = pattern.toCharArray();
    final int range = xRange.length;
    // should be a bijection
    if (range != yRange.length) {
      return false;
    }

    final String[] mapping = new String[26]; // [a to z]
    final Set<String> yCheck = new HashSet<>();

    for (int i = 0; i < range; i++) {
      int pos = xRange[i] % 97;
      String yVal = yRange[i];
      if (mapping[pos] == null) {
        if (yCheck.contains(yVal)) {
          return false;
        }
        mapping[pos] = yVal;
        yCheck.add(yVal);
      } else if (!mapping[pos].equals(yVal)) {
        return false;
      }
    }
    return true;
  }
}
