package leetcode.p0383.hashtable;

class Solution {
  // Params consist of lowercase English letters.
  public boolean canConstruct(String ransomNote, String magazine) {
    final int[] countTable = new int[26];
    final int m = magazine.length();
    final int n = ransomNote.length();

    if (n > m) {
      return false;
    }

    for (int i = 0; i < m; i++) {
      final int x = magazine.charAt(i) - 'a';
      countTable[x]++;
    }

    for (int i = 0; i < n; i++) {
      final int x = ransomNote.charAt(i) - 'a';
      if (countTable[x] == 0) {
        return false;
      }
      countTable[x]--;
    }

    return true;
  }
}
