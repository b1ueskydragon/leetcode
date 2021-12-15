package leetcode.p0680.recursive;

/**
 * Return true if the String s can be palindrome after deleting at most one character from it.
 */
class Solution {
  public boolean validPalindrome(String s) {
    return validPalindrome(s, 0, s.length() - 1, 0);
  }

  private boolean validPalindrome(String s, int l, int r, int unmatched) {
    while (l <= r) {
      if (unmatched > 1) {
        return false;
      }
      if (s.charAt(l) == s.charAt(r)) {
        l++;
        r--;
        continue;
      }
      return validPalindrome(s, l + 1, r, unmatched + 1) || validPalindrome(s, l, r - 1, unmatched + 1);
    }

    return true;
  }
}
