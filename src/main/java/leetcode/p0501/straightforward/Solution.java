package leetcode.p0501.straightforward;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {this.val = val;}

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  private static final int a = 100000;

  // The number of nodes in the tree is in the range [1, 10^4].
  // -10^5 <= Node.val <= 10^5
  public int[] findMode(TreeNode root) {
    final int[] table = new int[a * 2 + 1];
    findMode(root, table);

    int maxCount = 0;
    int maxCountFreq = 0;
    for (final int currCount : table) {
      if (maxCount == currCount) {
        maxCountFreq++;
        continue;
      }
      if (maxCount < currCount) {
        maxCount = currCount;
        maxCountFreq = 1;
      }
    }

    final int[] filtered = new int[maxCountFreq];
    int j = 0;
    for (int i = 0; i < table.length; i++) {
      if (table[i] == maxCount) {
        filtered[j++] = i - a;
      }
    }
    return filtered;
  }

  private void findMode(TreeNode root, int[] table) {
    if (root == null) {
      return;
    }
    table[root.val + a]++;
    findMode(root.left, table);
    findMode(root.right, table);
  }
}
