package leetcode.p0103.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    final Deque<TreeNode> dq = new LinkedList<>();
    dq.addFirst(root);
    int level = 0;
    while (!dq.isEmpty()) {
      final LinkedList<Integer> chunk = new LinkedList<>();
      // constraint with current level's size, since some of the trees are not well-balanced
      final int capacity = dq.size();
      for (int i = 0; i < capacity; i++) {
        final TreeNode parent = dq.pollFirst();
        if (parent == null) {
          continue;
        }
        if (parent.left != null) {
          dq.addLast(parent.left);
        }
        if (parent.right != null) {
          dq.addLast(parent.right);
        }

        if (level % 2 != 0) {
          chunk.addFirst(parent.val);
        } else {
          chunk.addLast(parent.val);
        }
      }
      level++;
      res.add(chunk);
    }
    return res;
  }
}
