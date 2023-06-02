package leetcode.p0009;

class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int tmp = x;
    int acc = 0;
    while (x > 0) {
      acc = acc * 10 + x % 10;
      x = (x - x % 10) / 10;
    }
    return acc == tmp;
  }
}
