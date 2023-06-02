package leetcode.p0226.bfs;

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
    final Deque<TreeNode> dq = new ArrayDeque<>();
    dq.add(root);
    while (!dq.isEmpty()) {
      final int size = dq.size();
      for (int i = 0; i < size; i++) {
        final TreeNode head = dq.poll();

        if (head.left != null) {
          dq.add(head.left);
        }
        if (head.right != null) {
          dq.add(head.right);
        }

        TreeNode tmp = head.left;
        head.left = head.right;
        head.right = tmp;
      }
    }
    return root;
  }
}
