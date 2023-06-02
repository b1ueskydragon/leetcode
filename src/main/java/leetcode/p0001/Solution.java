package leetcode.p0001;

import java.util.HashMap;
import java.util.Map;

class Solution {
  // Each input would have exactly one solution, and you may not use the same element twice.
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> pair = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      int y = target - x;
      if (pair.containsKey(y)) {
        return new int[]{pair.get(y), i};
      }
      pair.put(x, i);
    }
    return new int[2];
  }
}
