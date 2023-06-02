package leetcode.p0112;

class Solution {
  // Sum up root-to-leaf.
  // A leaf is a node with no children.    
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false; // edge case.
    }
    if (root.left == null && root.right == null) { // compare only when reached to the leaf.
      return sum == root.val;
    }
    if (root.left != null) { // acc only if exists
      root.left.val += root.val;
    }
    if (root.right != null) { // acc only if exists
      root.right.val += root.val;
    }
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}
