package leetcode.p0543.dfs_memo_functional;

class Solution {
  //  This path may or may not pass through the root.
  public int diameterOfBinaryTree(TreeNode root) {
    return calcMaxDiameter(root)[0];
  }

  private int[] calcMaxDiameter(TreeNode node) {
    if (node == null) {
      // {maxDiameter, soFar}
      return new int[]{-1, -1};
    }
    final int[] calcLeft = calcMaxDiameter(node.left);
    final int[] calcRight = calcMaxDiameter(node.right);

    final int leftSoFar = calcLeft[1] + 1;
    final int rightSoFar = calcRight[1] + 1;
    final int maxSoFar = Math.max(calcLeft[0], calcRight[0]);

    final int maxDiameter = Math.max(maxSoFar, leftSoFar + rightSoFar);

    return new int[]{maxDiameter, Math.max(leftSoFar, rightSoFar)};
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {this.val = val;}

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
