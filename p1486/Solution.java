package leetcode.p1486;

class Solution {
  public int xorOperation(int n, int start) {
    int xorRes = start;
    int i = 1;
    while (i < n) {
      xorRes ^= (start + 2 * i);
      i++;
    }
    return xorRes;
  }
}
