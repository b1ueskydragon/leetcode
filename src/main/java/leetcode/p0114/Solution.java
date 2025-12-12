package leetcode.p0114;

import leetcode.common.TreeNode;

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

class Solution01 {

  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    TreeNode tmp = root.right;
    root.right = root.left;
    root.left = null;
    while (root.right != null) {
      root = root.right;
    }
    root.right = tmp;
  }
}
