package leetcode.p0098.dfs.functional;

import leetcode.common.TreeNode;

class Solution {
  private boolean isValid(TreeNode node, Integer minLimit, Integer maxLimit) {
    if (node == null) {
      return true;
    }
    if (maxLimit != null && node.val >= maxLimit) {
      return false;
    }
    if (minLimit != null && node.val <= minLimit) {
      return false;
    }

    boolean isLeftValid = isValid(node.left, minLimit, node.val);
    // return to the `node` at this point.
    boolean isRightValid = isValid(node.right, node.val, maxLimit);
    return isLeftValid && isRightValid;
  }

  public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
  }
}
