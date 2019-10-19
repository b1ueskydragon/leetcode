package leetcode.p0114;

// binary tree node
class TreeNode {
  final int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    this.val = x;
  }
}

class Solution {
  private TreeNode prevRoot;

  public Solution() {
    prevRoot = null;
  }

  // in-place
  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.right);
    flatten(root.left);
    root.right = prevRoot;
    root.left = null;
    prevRoot = root;
  }
}
