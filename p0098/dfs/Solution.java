package leetcode.p0098.dfs;

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
  private Integer prev = null;
  private boolean isValid = true;

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(node.left);
    if (prev != null && prev >= node.val) {
      isValid &= false;
      return;
    }
    prev = node.val;
    dfs(node.right);
  }

  public boolean isValidBST(TreeNode root) {
    dfs(root);
    return isValid;
  }
}
