package leetcode.p0129.dfs.globalVar;

import leetcode.common.TreeNode;

class Solution {
  int res = 0;

  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode node, int acc) {
    if (node == null) {
      return;
    }

    // type int is primitive.
    dfs(node.left, acc * 10 + node.val);

    // leaf
    if (node.left == null && node.right == null) {
      res += acc * 10 + node.val;
    }

    dfs(node.right, acc * 10 + node.val);
  }

}
