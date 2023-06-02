package leetcode.p0046.swap;

import java.util.ArrayList;
import java.util.List;

class Solution {
  /**
   * @param nums distinct integers
   */
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> res = new ArrayList<>();
    permute(nums, 0, res);
    return res;
  }

  private void permute(final int[] nums,
                       final int headPos,
                       final List<List<Integer>> res) {
    // base case
    if (headPos == nums.length) {
      final List<Integer> node = new ArrayList<>();
      for (int num : nums) {
        node.add(num);
      }
      res.add(node);
      return;
    }

    for (int i = headPos; i < nums.length; i++) {
      swap(nums, i, headPos);
      permute(nums, headPos + 1, res);
      swap(nums, i, headPos); // revert

    }
  }

  private static void swap(final int[] xs,
                           final int i,
                           final int j) {
    int tmp = xs[i];
    xs[i] = xs[j];
    xs[j] = tmp;
  }
}
