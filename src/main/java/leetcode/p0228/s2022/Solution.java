package leetcode.p0228.s2022;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // nums is a sorted (ascending) unique integer array
  public List<String> summaryRanges(int[] nums) {
    final List<String> res = new ArrayList<>();
    if (nums.length == 0) {
      return res;
    }

    int prev = nums[0];
    int init = prev;

    for (int i = 1; i < nums.length; i++) {
      int curr = nums[i];
      if (curr - prev != 1) {
        append(res, init, prev);
        init = curr;
      }
      prev = curr;
    }
    // flush
    append(res, init, prev);
    return res;
  }

  // allow a side effect
  private static void append(List<String> list, int to, int from) {
    if (to == from) {
      list.add(String.valueOf(from));
      return;
    }
    final StringBuilder sb = new StringBuilder();
    sb.append(to);
    sb.append("->");
    sb.append(from);
    list.add(sb.toString());
  }
}
