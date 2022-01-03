package leetcode.p0228.straightforward;

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
      if (curr - prev != 1) { // care the case of prev=-2147483647, curr=2147483647
        if (init == prev) {
          res.add(String.valueOf(prev));
        } else {
          res.add(String.format("%s->%s", init, prev));
        }
        init = curr;
      }
      prev = curr;
    }
    // flush
    if (init == prev) {
      res.add(String.valueOf(prev));
    } else {
      res.add(String.format("%s->%s", init, prev));
    }

    return res;
  }
}

