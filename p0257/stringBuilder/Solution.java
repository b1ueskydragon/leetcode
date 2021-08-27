package leetcode.p0257.stringBuilder;

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
    final StringBuilder sb = new StringBuilder();
    binaryTreePaths(root, res, sb);
    return res;
  }

  private void binaryTreePaths(final TreeNode root,
                               final List<String> res,
                               final StringBuilder sb) {
    if (root == null) {
      return;
    }

    // include priveous "-" and ">"
    final int sizeSoFar = sb.length();

    sb.append(root.val);

    if (root.left == null && root.right == null) {
      // reach to the leaf
      res.add(sb.toString());
    } else {
      sb.append("->");
      binaryTreePaths(root.left, res, sb);
      binaryTreePaths(root.right, res, sb);
    }

    // mutable.
    // resize (rewind) to an accumulated length of the current root to prepare to search a next child
    sb.setLength(sizeSoFar);
  }
}
