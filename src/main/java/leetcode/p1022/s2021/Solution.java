package leetcode.p1022.s2021;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int sumRootToLeaf(TreeNode root) {
    final Deque<NodePair> stack = new ArrayDeque<>();
    stack.push(new NodePair(root, 0));

    int res = 0;
    while (!stack.isEmpty()) {
      final NodePair curr = stack.pop();
      final TreeNode node = curr.node;
      curr.acc = (curr.acc << 1) + node.val;
      if (node.left == null && node.right == null) {
        res += curr.acc;
        continue;
      }
      if (node.right != null) stack.push(new NodePair(node.right, curr.acc));
      if (node.left != null) stack.push(new NodePair(node.left, curr.acc));
    }

    return res;
  }

  private static class NodePair {
    TreeNode node;
    Integer acc;

    NodePair(TreeNode node, Integer acc) {
      this.node = node;
      this.acc = acc;
    }
  }
}
