package leetcode.p0520.s2021;

class Solution {
  // Valid conditions
  // - capitals == length
  // - capitals == 0
  // - only word[0] is a capital
  public boolean detectCapitalUse(String word) {
    final int N = word.length();
    if (N <= 1) return true;

    final int head = word.charAt(0);
    if (!isCapital(head)) {
      for (int i = 1; i < N; i++) {
        if (isCapital(word.charAt(i))) return false;
      }
      return true;
    }
    if (isCapital(word.charAt(1))) {
      for (int i = 2; i < N; i++) {
        if (!isCapital(word.charAt(i))) return false;
      }
      return true;
    }
    for (int i = 2; i < N; i++) {
      if (isCapital(word.charAt(i))) return false;
    }
    return true;
  }

  private static boolean isCapital(int ord) {
    return ord >= 65 && ord <= 90;
  }
}
