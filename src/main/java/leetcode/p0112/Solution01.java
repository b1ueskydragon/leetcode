package leetcode.p0112;

import leetcode.common.TreeNode;

class Solution01 {
  // Sum up root-to-leaf.
  // A leaf is a node with no children.
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false; // edge case.
    }
    if (root.left == null && root.right == null) { // compare only when reached to the leaf.
      return sum == root.val;
    }
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
