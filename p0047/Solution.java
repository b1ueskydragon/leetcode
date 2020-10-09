package leetcode.p0047;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    return permuteUnique(nums, 0, new ArrayList<>());
  }

  private List<List<Integer>> permuteUnique(final int[] nums,
                                            final int headPos,
                                            final List<List<Integer>> res) {
    if (headPos == nums.length) {
      final List<Integer> swapped = new ArrayList<>();
      for (int num : nums) {
        swapped.add(num);
      }
      res.add(swapped);
      return res;
    }

    // recount every recursion (the own counter for each permutation)
    final Set<Integer> usedHead = new HashSet<>();

    // each level (headPos) will be revisited but make a different choice
    for (int i = headPos; i < nums.length; i++) {
      final int head = nums[i];
      if (usedHead.contains(head)) {
        continue;
      }
      swap(nums, headPos, i);
      permuteUnique(nums, headPos + 1, res);
      swap(nums, headPos, i); // revert

      usedHead.add(head); // add after getting out from the recursion
    }

    return res;
  }

  private static void swap(final int[] nums,
                            final int i,
                            final int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
