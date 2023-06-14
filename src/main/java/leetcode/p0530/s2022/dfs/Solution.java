package leetcode.p0530.s2022.dfs;

class Solution {
    private int prev = 10_001;
    private int minDiff = 10_001;

    // Use Binary Search Tree property which guarantees left <= right
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }

        getMinimumDifference(root.left);

        minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        prev = root.val;

        getMinimumDifference(root.right);

        return minDiff;
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
