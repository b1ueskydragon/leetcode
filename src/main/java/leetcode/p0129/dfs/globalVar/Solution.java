package leetcode.p0129.dfs.globalVar;

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
  int res = 0;

  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode node, int acc) {
    if (node == null) {
      return;
    }

    // type int is primitive.
    dfs(node.left, acc * 10 + node.val);

    // leaf
    if (node.left == null && node.right == null) {
      res += acc * 10 + node.val;
    }

    dfs(node.right, acc * 10 + node.val);
  }

}
