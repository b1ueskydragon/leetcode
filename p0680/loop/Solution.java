package leetcode.p0680.loop;

class Solution {
  public boolean validPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l <= r) {
      // The first occurrence was detected.
      if (s.charAt(l) != s.charAt(r)) {
        // Check if there is another occurrence.
        return isValidPalindrome(l + 1, r, s) || isValidPalindrome(l, r - 1, s);
      }
      l++;
      r--;
    }
    return true;
  }

  // The responsibility is checking only whether section s is a valid palindrome or not.
  private static boolean isValidPalindrome(int l, int r, String s) {
    while (l <= r) {
      if (s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
  }
}
