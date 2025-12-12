package leetcode.p0098.dfs.globalVar;

import leetcode.common.TreeNode;

class Solution {
  private Integer prev = null;
  private boolean isValid = true;

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(node.left);
    if (prev != null && prev >= node.val) {
      isValid &= false;
      return;
    }
    prev = node.val;
    dfs(node.right);
  }

  public boolean isValidBST(TreeNode root) {
    dfs(root);
    return isValid;
  }
}
