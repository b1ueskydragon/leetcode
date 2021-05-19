package leetcode.p0226.dfs.stack;

import java.util.ArrayDeque;
import java.util.Deque;

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
      return null;
    }

    final Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      TreeNode left = node.left;
      TreeNode right = node.right;

      node.left = right;
      node.right = left;

      if (left != null) {
        stack.push(left);
      }
      if (right != null) {
        stack.push(right);
      }
    }

    return root;
  }
}
