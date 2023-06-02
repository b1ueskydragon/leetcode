package leetcode.p0102.recursion;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) { this.val = val; }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    return levelOrder(root, new ArrayList<>(), 0);
  }

  private List<List<Integer>> levelOrder(TreeNode root,
                                         List<List<Integer>> result,
                                         int level) {
    if (root == null) {
      return result;
    }
    // Build a new array for each level, 
    // then it will append a new element of the level, when the each recursion was finished
    if (result.size() <= level) {
      List<Integer> currLevel = new ArrayList<>();
      result.add(currLevel);
    }
    result.get(level).add(root.val);

    // After getting out of recursion, make different choice      
    levelOrder(root.left, result, level + 1);
    levelOrder(root.right, result, level + 1);

    return result;
  }
}
