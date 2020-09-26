package leetcode.p0066;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
  public int[] plusOne(int[] digits) {
    final int n = digits.length;
    final Deque<Integer> queue = new LinkedList<>();
    int d = 1;
    for (int i = n - 1; i >= 0; i--) {
      int digit = digits[i];
      if (d + digit == 10) {
        queue.addFirst(0);
        d = 1;
        continue;
      }
      queue.addFirst(d + digit);
      d = 0;
    }
    if (d == 1) {
      queue.addFirst(1);
    }
    return queue.stream().mapToInt(x -> x).toArray();
  }
}
