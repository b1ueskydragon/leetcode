package leetcode.p0344;

class Solution {
  // modify the input array in-place with O(1) extra memory
  public void reverseString(char[] s) {
    int l = 0, r = s.length - 1;
    while (l <= r) {
      char t = s[l];
      s[l++] = s[r];
      s[r--] = t;
    }
  }
}
