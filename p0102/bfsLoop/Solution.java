package leetcode.p0102.bfsLoop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      final int currLevelCount = queue.size();
      final List<Integer> slot = new ArrayList<>();
      for (int i = 0; i < currLevelCount; i++) {
        final TreeNode parent = queue.poll();
        if (parent != null) {
          slot.add(parent.val);
        }
        if (parent.left != null) {
          queue.offer(parent.left);
        }
        if (parent.right != null) {
          queue.offer(parent.right);
        }
      }
      result.add(slot);
    }

    return result;
  }
}
