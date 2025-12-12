package leetcode.p0100.dfs;

import leetcode.common.TreeNode;

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if ((p == null && q != null) ||
        (p != null && q == null)) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    if ((p.left != null && q.left == null) ||
        (p.left == null && q.left != null)) {
      return false;
    }

    if ((p.right != null && q.right == null) ||
        (p.right == null && q.right != null)) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
