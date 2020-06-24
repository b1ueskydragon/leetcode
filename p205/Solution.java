package leetcode.p205;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    // only containsKey performs as a constant time,
    // and containsValue requires linear time to retrieval,
    // so I prefer to use two caches to improve speed.
    final Map<Character, Character> x2y = new HashMap<>();
    final Map<Character, Character> y2x = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i), y = t.charAt(i);
      if (!x2y.containsKey(x)) {
        x2y.put(x, y);
      } else if (x2y.get(x) != y) {
        return false;
      }

      if (!y2x.containsKey(y)) {
        y2x.put(y, x);
      } else if (y2x.get(y) != x) {
        return false;
      }
    }
    return true;
  }
}
