package leetcode.p0701.dfs;

import leetcode.common.TreeNode;

class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    // Create a new node at this point
    if (root == null) {
      return new TreeNode(val);
    }
    // Append the node to a current level root after breaking out of recursion
    if (root.val > val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }
}
