package leetcode.p1022.s2026;

import leetcode.common.TreeNode;

class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int acc) {
        if (root == null) {
            return 0;
        }
        acc = (acc << 1) + root.val;
        int left = dfs(root.left, acc);
        int right = dfs(root.right, acc);
        // right recursion まで抜けたら一度 acc 完成.
        // 作った acc のなかで, sum up only when we reached to the leaf.
        if (root.left == null && root.right == null) {
            return acc;
        }
        // Other nodes aggregate valid left + valid right
        // to propagate the total sum up to the root.
        return left + right;
    }
}
