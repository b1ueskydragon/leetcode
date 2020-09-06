package leetcode.p0191;

//  3 + (-3) = 0
//  0 - 3 = 3
//  0 : (1)00000000000000000000000000000000
// -3 :  - 11111111111111111111111111111101
//  3 :                                  11
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int cnt = 0;
    while (n != 0) {
      cnt += (n & 1);
      n >>>= 1; // unsigned right shift operation
    }
    return cnt;
  }
}
