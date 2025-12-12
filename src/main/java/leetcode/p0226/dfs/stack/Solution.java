package leetcode.p0226.dfs.stack;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

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
