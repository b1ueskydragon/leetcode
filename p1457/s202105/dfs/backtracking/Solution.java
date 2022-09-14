package leetcode.p1457.s202105.dfs.backtracking;

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
  int acc = 0;

  public int pseudoPalindromicPaths(TreeNode root) {
    final int[] table = new int[10];
    pseudoPalindromicPaths(root, table);
    return acc;
  }

  private void pseudoPalindromicPaths(TreeNode root, int[] table) {
    if (root == null) {
      return;
    }

    // count up of current node's val
    table[root.val]++;

    if (root.left == null && root.right == null) {
      // reached to the leaf
      if (isPseudoPalindrome(table)) {
        acc++;
      }
    }

    pseudoPalindromicPaths(root.left, table);
    pseudoPalindromicPaths(root.right, table);

    // prepare the backtracking
    table[root.val]--;
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
}
