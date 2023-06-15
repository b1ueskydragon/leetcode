package leetcode.p1161.s2020;

class Solution01 {
  // make as global to stable status
  private int maxLevel = 1;
  // The number of nodes in the given tree is between 1 and 10^4
  private int[] nodes = new int[10000];

  public int maxLevelSum(TreeNode root) {
    dfs(root, 1);
    int maxRes = root.val;
    int resLevel = 1;
    for (int i = 1; i < maxLevel; i++) {
      if (nodes[i] > maxRes) {
        maxRes = nodes[i];
        resLevel = i;
      }
    }
    return resLevel;
  }

  private void dfs(TreeNode root, int currLevel) {
    if (root == null) return; // base
    maxLevel = (currLevel > maxLevel) ? currLevel : maxLevel; // global
    nodes[currLevel] += root.val;
    dfs(root.left, currLevel + 1);
    dfs(root.right, currLevel + 1);
  }
}
