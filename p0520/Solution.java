package leetcode.p0520;

class Solution {
  // Valid conditions
  // - only word[0] is a capital
  // - capitals == length
  // - capitals == 0
  public boolean detectCapitalUse(String word) {
    final int N = word.length();
    int capitals = 0;
    for (int i = 1; i < N; i++) {
      final int ord = word.charAt(i);
      if (isCapital(ord)) {
        capitals++;
      }
    }
    final int head = word.charAt(0);
    if (isCapital(head)) {
      return capitals + 1 == N || capitals == 0;
    }
    return capitals == 0;
  }

  private static boolean isCapital(int ord) {
    return ord >= 65 && ord <= 90;
  }
}
