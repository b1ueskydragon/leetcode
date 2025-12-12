package leetcode.p0226.dfs.recursive;

import leetcode.common.TreeNode;

class Solution {
  // recursive solution is dependent on an application stack
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    // null and null exchange will occur when current root hasn't any children
    root.right = left;
    root.left = right;

    return root;
  }
}
