package leetcode.p0530.s2023.dfs;


class Solution {
    // values are unique
    // constraint: 0 <= val <= 100_000
    private int minDiff = 100_001;
    private int prevVal = 100_001;

    // Binary Search Tree
    // which guarantees left.val < root.val < right.val
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left);
        minDiff = Math.min(minDiff, Math.abs(root.val - prevVal));
        prevVal = root.val;
        getMinimumDifference(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
