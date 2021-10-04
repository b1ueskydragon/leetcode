package leetcode.p0108.divide_and_conquer.recursive;

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
  // Divide and Conquer
  // nums are sorted in ascending order
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
    // since pivot has been excluded to avoid duplication
    if (l > r) {
      return null;
    }

    int p = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[p]);

    if (l == r) {
      return root;
    }

    // exclude pivot to avoid duplication
    TreeNode leftNode = sortedArrayToBST(nums, l, p - 1);
    TreeNode rightNode = sortedArrayToBST(nums, p + 1, r);

    root.left = leftNode;
    root.right = rightNode;

    return root;
  }
}
