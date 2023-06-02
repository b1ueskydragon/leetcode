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
    // StringBuilder is more efficient than string concat (+=) in the loop,
    // since concatenation generates new instance in each loop.
    final StringBuilder res = new StringBuilder();
    int currCount = 1;
    char prev = '0';

    for (char curr : numStr.toCharArray()) {
      if (curr == prev) {
        currCount += 1;
      } else {
        // About StringBuilder#append,
        // The overall effect is exactly as if the argument were converted
        // to a string by the method String#valueOf.
        if (prev != '0') res.append(currCount).append(prev);
        currCount = 1;
      }
      prev = curr;
    }
    res.append(currCount).append(prev);
    return res.toString();
  }
}
