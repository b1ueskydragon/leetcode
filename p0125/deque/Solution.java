package leetcode.p0125.deque;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  // Considering only alphanumeric characters and ignoring cases.
  // s consists only of printable ASCII characters.
  public boolean isPalindrome(String s) {
    final Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      final int x = s.charAt(i);
      // numeric
      if (x >= 48 && x <= 57) {
        dq.addLast(x);
        continue;
      }

      // Upper cases
      if (x >= 65 && x <= 90) {
        dq.addLast(x + 32);
        continue;
      }
      // Lower cases
      if (x >= 97 && x <= 122) {
        dq.addLast(x);
      }
    }

    while (!dq.isEmpty()) {
      if (dq.size() < 2) {
        return true;
      }
      if (dq.pollFirst() != dq.pollLast()) {
        return false;
      }
    }
    return true;
  }
}
