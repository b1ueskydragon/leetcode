package leetcode.p0383.hashtable;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    final Map<Character, Integer> countTable = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char x = magazine.charAt(i);
      countTable.putIfAbsent(x, 0);
      countTable.put(x, countTable.get(x) + 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char x = ransomNote.charAt(i);
      if (!countTable.containsKey(x)) {
        return false;
      }
      if (countTable.get(x) == 0) {
        return false;
      }
      countTable.put(x, countTable.get(x) - 1);
    }

    return true;
  }
}
