package leetcode.p0038;

class Solution {
  // 1 <= n <= 30
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    int res = 1;
    for (int i = 0; i < n - 1; i++) {
      res = Integer.parseInt(numToCount(res));
    }
    return String.valueOf(res);
  }

  // 11 -> 2 * 1
  // 21 -> 1 * 2, 1 * 1
  private String numToCount(int num) {
    String res = "";
    int currCount = 1;
    int prev = 0;
    while (num > 0) {
      int curr = num % 10;
      if (curr == prev) {
        currCount += 1;
      } else {
        if (prev != 0) res = String.valueOf(currCount) + prev + res;
        currCount = 1;
      }
      prev = curr;
      num /= 10;
    }
    res = String.valueOf(currCount) + prev + res;
    return res;
  }
}

