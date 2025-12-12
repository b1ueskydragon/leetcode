package leetcode.p0191.improve;

// Remove the least significant 1 in each loop.
class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int cnt = 0;
    while (n != 0) {
      cnt++;
      n = n & (n - 1);
    }
    return cnt;
  }
}
