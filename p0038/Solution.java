package leetcode.p0038;

class Solution {
  // 1 <= n <= 30
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String res = "1";
    for (int i = 0; i < n - 1; i++) {
      res = numToCount(res);
    }
    return res;
  }

  // 11 -> 2 * 1
  // 21 -> 1 * 2, 1 * 1
  private String numToCount(String numStr) {
    String res = "";
    int currCount = 1;
    char prev = '0';

    for (char curr : numStr.toCharArray()) {
      if (curr == prev) {
        currCount += 1;
      } else {
        if (prev != '0') res = res + String.valueOf(currCount) + prev;
        currCount = 1;
      }
      prev = curr;
    }

    res = res + String.valueOf(currCount) + prev;
    return res;
  }
}
