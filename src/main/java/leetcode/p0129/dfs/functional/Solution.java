package leetcode.p0129.dfs.functional;

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
  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  private int sum(TreeNode node, int acc) {
    if (node == null) {
      return 0;
    }

    // leaf
    if (node.left == null && node.right == null) {
      return acc * 10 + node.val;
    }

    // type int is primitive.
    int leftAcc = sum(node.left, acc * 10 + node.val);
    int rightAcc = sum(node.right, acc * 10 + node.val);
    return leftAcc + rightAcc;
  }
}
