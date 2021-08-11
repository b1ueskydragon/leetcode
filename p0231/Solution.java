package leetcode.p0231;

class Solution {
  /**
   * All Power of Two (an integer n is a power of two, and x is an integer also, n == 2^x) numbers are
   * - positive
   * - have only one `1` as a most significant bit, and `0` follows.
   */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
