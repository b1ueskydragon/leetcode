package leetcode.p0004;

class Solution {
  private static boolean isCommonPrefix(String[] strs, String prefix) {
    for (String str : strs) {
      if (!str.startsWith(prefix)) return false;
    }
    return true;
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }
    final String maybeLcp = strs[0];
    int low = 1;
    int high = minLen;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isCommonPrefix(strs, maybeLcp.substring(0, mid))) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return maybeLcp.substring(0, (low + high) / 2);
  }
}
