package leetcode.p0507;

class Solution {
  public boolean checkPerfectNumber(int num) {
    int divisorSum = 0;
    for (int k = 1; k <= Math.pow(num, 0.5); k++) {
      if (num % k != 0) {
        continue;
      }
      divisorSum += k;

      if (k == num / k) {
        continue;
      }
      divisorSum += num / k;
    }
    return num == divisorSum - num;
  }
}
