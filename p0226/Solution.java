package leetcode.p0226;

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
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode tmp = root.right;
    root.right = root.left;
    root.left = tmp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
