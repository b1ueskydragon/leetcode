package leetcode.p0078.dfs.globalVar;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private final List<List<Integer>> res = new ArrayList<>();

  // pos is a level. pos(+1) for moving vertically (going deeper),
  // dfs-recursion for moving horizontally (left to right).
  private void dfs(int[] nums, int pos, List<Integer> node) {
    // reached to the leaf-level.
    if (pos == nums.length) {
      res.add(node);
      return;
    }
    // only left-node appends a number ( build a new node).
    final List<Integer> leftNode = new ArrayList<>(node);
    leftNode.add(nums[pos]);
    dfs(nums, pos + 1, leftNode);
    // returned to the `node` num at this point.
    // right node just extends parent's node.
    dfs(nums, pos + 1, node);
  }

  public List<List<Integer>> subsets(int[] nums) {
    dfs(nums, 0, new ArrayList<>());
    return res;
  }
}
