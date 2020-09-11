package leetcode.p0098.dfs.genList;

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
  final List<Integer> nodes = new ArrayList<>();

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    nodes.add(node.val);
    dfs(node.right);
  }

  public boolean isValidBST(TreeNode root) {
    dfs(root);
    int i = 1;
    while (i < nodes.size()) {
      if (nodes.get(i - 1) >= nodes.get(i)) return false;
      i++;
    }
    return true;
  }
}
