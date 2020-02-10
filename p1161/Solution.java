
package leetcode.p1161;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) { this.val = x; }
}

class Solution {
  // TODO: use an Array.
  //  we don't need to use a list. since there is an limit range in the question ...
  public int maxLevelSum(TreeNode root) {
    // if (root == null) System.exit(0);

    int currLevel = 1;
    int maxLevel = currLevel;
    int maxRes = root.val;
    List<TreeNode> parents = new ArrayList<>();
    parents.add(root);

    while (!parents.isEmpty()) {
      // initialize each time when parents are replaced.
      int currRes = 0;
      List<TreeNode> children = new ArrayList<>();

      for (TreeNode node : parents) { // retrieval the breadth (level)
        if (node.left != null) {
          currRes += node.left.val;
          children.add(node.left);
        }
        if (node.right != null) {
          currRes += node.right.val;
          children.add(node.right);
        }
      }
      // increment first
      currLevel++;
      parents = children;

      // dp
      if (currRes > maxRes) {
        maxRes = currRes;
        maxLevel = currLevel;
      }
    }

    return maxLevel;
  }
}
