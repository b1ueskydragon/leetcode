package leetcode.p2265;

import leetcode.common.TreeNode;

class Solution {
    public int averageOfSubtree(TreeNode root) {
        return rec(root)[0];
    }

    private int[] rec(TreeNode root) {
        if (root == null) {
            return null;
        }

        // base case.
        // every leaf, itself is the average.
        if (root.left == null && root.right == null) {
            // {answer (matching) node count, acc, every node count}
            // !! accumulate bottom to top !!
            return new int[]{1, root.val, 1};
        }

        final int[] left = rec(root.left);
        final int[] right = rec(root.right);

        int ansSoFar = 0;
        int sumSoFar = root.val;
        int nodes = 1;

        if (left != null) {
            ansSoFar += left[0];
            sumSoFar += left[1];
            nodes += left[2];
        }
        if (right != null) {
            ansSoFar += right[0];
            sumSoFar += right[1];
            nodes += right[2];
        }
        // compare to the avg (round down).
        if (sumSoFar / nodes == root.val) {
            ansSoFar++; // count a root itself.
        }

        return new int[]{ansSoFar, sumSoFar, nodes};
    }
}
