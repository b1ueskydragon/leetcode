package leetcode.p0028;

class Solution {
  // This doesn't depend on originalStr.
  public static int[] skipTable(String subStr) {
    final int K = subStr.length();
    final int[] table = new int[K + 1]; // table[0] is a sentinel.
    int i = 0, j = 1;
    while (j < K) {
      if (subStr.charAt(i) == subStr.charAt(j)) {
        table[++j] = ++i; // increment first, since of the sentinel index.
      } else {
        table[++j] = table[i];
      }
    }
    return table;
  }

  public int strStr(String haystack, String needle) {
    final int[] skipTable = skipTable(needle);
    int n = 0, k = 0;
    while (k < needle.length() && n < haystack.length()) {
      if (haystack.charAt(n) == needle.charAt(k)) {
        n++;
        k++;
      } else if (k == 0) {
        n++;
      } else {
        k = skipTable[k]; // Don't move n yet.
      }
    }
    return k == needle.length() ? n - k : -1;
  }
}
