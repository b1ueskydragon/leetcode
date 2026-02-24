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
        acc = (acc << 1) + root.val;
        dfs(root.left, acc);
        dfs(root.right, acc);
        // right recursion まで抜けたら一度 acc 完成.
        // 作った acc のなかで, sum up only when we reached to the leaf.
        if (root.left == null && root.right == null) {
            sum += acc;
        }
    }
}
