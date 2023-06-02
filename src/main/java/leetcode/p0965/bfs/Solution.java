package leetcode.p0965.bfs;

import java.util.LinkedList;
import java.util.Queue;

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
  public boolean isUnivalTree(TreeNode root) {
    final Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      final TreeNode parent = queue.poll();
      if (parent.left != null) {
        if (parent.val != parent.left.val) {
          return false;
        }
        queue.offer(parent.left);
      }
      if (parent.right != null) {
        if (parent.val != parent.right.val) {
          return false;
        }
        queue.offer(parent.right);
      }
    }
    return true;
  }
}
