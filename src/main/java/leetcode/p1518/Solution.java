package leetcode.p1518;

class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int bottles = numBottles;
    int d = numBottles;
    int x = d / numExchange;
    while (x > 0) {
      x = d / numExchange;
      int r = d % numExchange;
      bottles += x;
      d = x + r;
    }
    return bottles;
  }
}
