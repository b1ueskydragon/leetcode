package leetcode.p0046;

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

    // build a new result for each level of permutation
    // those will be stacked on each level, and concatenated later after recursion
    final List<List<Integer>> res = new ArrayList<>();

    // base case. build a new result
    if (level == 0) {
      res.add(new ArrayList<>());
      return res;
    }

    for (int curr : nums) {
      final int[] rems = new int[nums.length - 1];
      int i = 0;
      for (int num : nums) {
        if (curr != num) rems[i++] = num;
      }
      final List<List<Integer>> interRes = permute(rems, level - 1);
      // append head (curr) to built permutation
      for (List<Integer> node : interRes) {
        node.add(curr);
        res.add(node);
      }
    }

    return res;
  }
}
