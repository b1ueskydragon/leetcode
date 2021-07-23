package leetcode.p0814;

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
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode left = pruneTree(root.left);
    TreeNode right = pruneTree(root.right);

    if (root.val == 0 && left == null && right == null) {
      return null;
    }

    root.left = left;
    root.right = right;

    return root;
  }
}
