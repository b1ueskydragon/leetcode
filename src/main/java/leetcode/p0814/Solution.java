package leetcode.p0814;

import leetcode.common.TreeNode;

class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode left = pruneTree(root.left);
    TreeNode right = pruneTree(root.right);

    if (root.val == 0 && left == null && right == null) {
      return null;
    }

    root.left = left;
    root.right = right;

    return root;
  }
}
