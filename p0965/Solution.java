package leetcode.p0965;


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
  // compare vertically
  public boolean isUnivalTree(final TreeNode node) {
    if (node == null) {
      return true;
    }
    final boolean isLeftSame = (node.left == null) || node.val == node.left.val;
    final boolean isLeftValid = isUnivalTree(node.left) && isLeftSame;
    final boolean isRightSame = (node.right == null) || node.val == node.right.val;
    final boolean isRightValid = isUnivalTree(node.right) && isRightSame;

    return isLeftValid && isRightValid;
  }

}
