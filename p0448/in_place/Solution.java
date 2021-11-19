package leetcode.p0448.in_place;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // Without extra space and in O(n) runtime.
  // The returned list does not count as extra space.
  public List<Integer> findDisappearedNumbers(int[] nums) {
    // Place element at correct index.
    // NOTE: just keep "marking" it and find numbers which have not marked.
    for (int i = 0; i < nums.length; i++) {
      final int toGo = Math.abs(nums[i]) - 1;
      // Already marked.
      if (nums[toGo] < 0) continue;
      nums[toGo] *= -1;
    }

    final List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) res.add(i + 1);
    }
    return res;
  }
}
