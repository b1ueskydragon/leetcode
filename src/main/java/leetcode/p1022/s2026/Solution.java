package leetcode.p1022.s2026;

import leetcode.common.TreeNode;

class Solution {
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int acc) {
        if (root == null) {
            return;
        }
        // acc を再利用しないので毎回式を再計算して渡す必要がある.
        dfs(root.left, (acc << 1) + root.val);
        dfs(root.right, (acc << 1) + root.val);

        // Sum up only when we reached to the leaf.
        if (root.left == null && root.right == null) {
            sum += (acc << 1) + root.val;
        }
    }
}
