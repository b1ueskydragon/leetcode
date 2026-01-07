package leetcode.p1339;

import leetcode.common.TreeNode;

class Solution {
    // T := Total sum
    // S := Sub tree sum
    // Find max (T - S) * S
    // edge を1つのみ消せる制約なのでこの形しか出ない.

    // Constraint: values are positive.
    long max = 0;
    private static final long M = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        write(root);
        final long total = 1L * root.val;
        read(root, total);
        return (int) (max % M);
    }

    // Constraint: 50_000 * 10_000 < 1_000_000_007 < Integer.MAX_VALUE
    private void write(TreeNode root) {
        if (root == null) {
            return;
        }
        write(root.left);
        write(root.right);
        // Rerun した先の accumulated sum を記録する.
        int l = (root.left == null) ? 0 : root.left.val;
        int r = (root.right == null) ? 0 : root.right.val;
        root.val += l + r;
    }

    // 1_000_000_007 ^ 2 < Long.MAX_VALUE
    private void read(TreeNode root, long total) {
        if (root == null) {
            return;
        }
        final long v = 1L * root.val;
        max = Math.max(max, (total - v) * v);
        read(root.left, total);
        read(root.right, total);
    }

}
