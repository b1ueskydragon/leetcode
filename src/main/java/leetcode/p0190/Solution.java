package leetcode.p0190;

class Solution {
  // you need treat n as an unsigned value
  // n is 32 bits unsigned integer
  // ... not (1 << 32) - 1 - n
  // reverse from left to right
  public int reverseBits(int n) {
    int rn = 0;
    // set a limit of the loop calls
    for (int i = 0; i < 31; i++) {
      rn += (n - ((n >> 1) << 1));
      rn <<= 1;
      n >>= 1;
    }
    // add bit 1 if n remains
    return rn + Math.abs(n);
  }
}
