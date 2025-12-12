package leetcode.p0701.bfs;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    final Deque<TreeNode> dq = new ArrayDeque<>();
    dq.addLast(root);

    while (!dq.isEmpty()) {
      final TreeNode p = dq.pollFirst();
      if (p.val > val) {
        if (p.left == null) {
          p.left = new TreeNode(val);
          break;
        }
        dq.addLast(p.left);
      } else {
        if (p.right == null) {
          p.right = new TreeNode(val);
          break;
        }
        dq.addLast(p.right);
      }
    }

    return root;
  }
}
