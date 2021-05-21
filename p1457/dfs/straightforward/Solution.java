package leetcode.p1457.dfs.straightforward;

import java.util.Arrays;

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
  public int pseudoPalindromicPaths(TreeNode root) {
    final int[] table = new int[10];
    return pseudoPalindromicPaths(new Node(root, table));
  }

  private int pseudoPalindromicPaths(Node root) {
    if (root.val == null) {
      return 0;
    }

    // count up of current node's val
    root.table[root.val.val]++;

    if (root.val.left == null && root.val.right == null) {
      // reached to the leaf
      return isPseudoPalindrome(root.table) ? 1 : 0;
    }

    root.left = new Node(root.val.left, Arrays.copyOf(root.table, 10));
    root.right = new Node(root.val.right, Arrays.copyOf(root.table, 10));

    return pseudoPalindromicPaths(root.left) + pseudoPalindromicPaths(root.right);
  }

  private boolean isPseudoPalindrome(int[] table) {
    int oddCountNumbers = 0;
    for (int count : table) {
      if (count % 2 != 0) {
        oddCountNumbers++;
      }
    }
    return oddCountNumbers <= 1;
  }

  private static class Node {
    TreeNode val;
    int[] table;
    Node left;
    Node right;

    Node(TreeNode val, int[] table) {
      this.val = val;
      this.table = table;
    }
  }
}
