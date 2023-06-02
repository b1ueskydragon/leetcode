package leetcode.p0046.useRemains;

import java.util.ArrayList;
import java.util.List;

class Solution {
  /**
   * @param nums distinct integers
   */
  public List<List<Integer>> permute(int[] nums) {
    return permute(nums, nums.length);
  }

  private List<List<Integer>> permute(final int[] nums,
                                      final int level) {

    final List<List<Integer>> res = new ArrayList<>();

    if (level == 0) {
      res.add(new ArrayList<>());
      return res;
    }

    for (int i = 0; i < nums.length; i++) {
      final int curr = nums[i];

      final int[] rems = remains(nums, i);
      final List<List<Integer>> interRes = permute(rems, level - 1);

      for (List<Integer> node : interRes) {
        node.add(curr);
        res.add(node);
      }
    }

    return res;
  }

  private static int[] remains(final int[] nums,
                               final int currPos) {
    final int[] rems = new int[nums.length - 1];
    int j = 0;
    for (int i = 0; i < currPos; i++) {
      rems[j++] = nums[i];
    }
    for (int i = currPos + 1; i < nums.length; i++) {
      rems[j++] = nums[i];
    }
    return rems;
  }
}
