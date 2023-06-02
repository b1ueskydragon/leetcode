package leetcode.p0125.twoPoints;

class Solution {
  // Considering only alphanumeric characters and ignoring cases.
  // s consists only of printable ASCII characters.
  public boolean isPalindrome(String s) {
    final int n = s.length();
    int l = 0, r = n - 1;

    while (l <= r) {
      while (l < n && !isAlphanumeric(s.charAt(l))) {
        l++;
      }

      while (r > 0 && !isAlphanumeric(s.charAt(r))) {
        r--;
      }

      if (l >= n || r < 0) {
        return true;
      }

      char lc = s.charAt(l);
      char rc = s.charAt(r);

      if (lc >= 65) {
        lc %= 32;
      }

      if (rc >= 65) {
        rc %= 32;
      }

      if (lc != rc) {
        return false;
      }

      l++;
      r--;
    }

    return true;
  }
  private static boolean isAlphanumeric(final char c) {
    return (c >= 48 && c <= 57) || (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
  }
}
