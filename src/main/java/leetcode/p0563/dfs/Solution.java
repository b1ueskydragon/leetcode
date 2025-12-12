package leetcode.p0563.dfs;

import leetcode.common.TreeNode;

class Solution {
    private int tilt;

    public int findTilt(TreeNode root) {
        findSum(root);
        return tilt;
    }

    // side effect
    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int leftSum = findSum(root.left);
        final int rightSum = findSum(root.right);

        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }
}
