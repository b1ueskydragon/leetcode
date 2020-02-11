package leetcode.p1161;

class Solution01 {
  // The number of nodes in the given tree is between 1 and 10^4
  private static int[] nodes = new int[10000];
  private static int maxLevel = 1;

  public int maxLevelSum(TreeNode root) {
    return -1; // TODO
  }

  private static void dfs(TreeNode root, int currLevel) {
    if (root == null) return; // base
    maxLevel = (currLevel > maxLevel) ? currLevel : maxLevel;
    nodes[currLevel] += root.val;
    dfs(root.left, currLevel + 1);
    dfs(root.right, currLevel + 1);
  }
}
