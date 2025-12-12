package leetcode.p0543.dfs_memo;

import leetcode.common.TreeNode;

class Solution {
  private int maxDiameter = -1; // side effect

  //  This path may or may not pass through the root.
  public int diameterOfBinaryTree(TreeNode root) {
    calcMaxDiameter(root);
    return maxDiameter;
  }

  private int calcMaxDiameter(TreeNode node) {
    if (node == null) {
      return -1;
    }
    final int leftSoFar = calcMaxDiameter(node.left) + 1;
    final int rightSoFar = calcMaxDiameter(node.right) + 1;

    maxDiameter = Math.max(maxDiameter, leftSoFar + rightSoFar);

    return Math.max(leftSoFar, rightSoFar);
  }
}
