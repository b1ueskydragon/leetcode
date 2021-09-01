package leetcode.p0257.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
  public List<String> binaryTreePaths(TreeNode root) {
    final List<String> res = new ArrayList<>();
    final ArrayDeque<Pair> stack = new ArrayDeque<>();
    stack.push(Pair.of(root, root.val));

    while (!stack.isEmpty()) {
      Pair current = stack.pop();
      TreeNode parent = current.node;
      String soFar = current.acc;

      if (parent.left == null && parent.right == null) {
        res.add(soFar);
      }
      if (parent.left != null) {
        stack.push(Pair.of(parent.left, soFar + "->" + parent.left.val));
      }
      if (parent.right != null) {
        stack.push(Pair.of(parent.right, soFar + "->" + parent.right.val));
      }
    }

    return res;
  }

  static class Pair {
    TreeNode node;
    String acc;

    Pair(TreeNode node, String acc) {
      this.node = node;
      this.acc = acc;
    }

    static Pair of(TreeNode node, Integer acc) {
      return new Pair(node, String.valueOf(acc));
    }

    static Pair of(TreeNode node, String acc) {
      return new Pair(node, acc);
    }
  }
}
