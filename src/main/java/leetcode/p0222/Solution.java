package leetcode.p0222;

import leetcode.common.TreeNode;

class Solution {
    // Constraint:
    // A `complete` binary tree
    // - Except possibly the last, is completely filled
    // - All nodes in the last level are as far left as possible.

    // Do it less than O(n) Time -> which may imply O(log n) Time.

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // ld == rd : At least, left is perfect
        // ld > rd : At least, right is perfect
        // ld < rd : An illegal state. if right exists, left must exist.
        int ld = leftDepth(root.left);
        int rd = leftDepth(root.right);

        if (ld == 0 && rd == 0) {
            return 1;
        }
        if (ld == rd) {
            // Accumulated a left perfect tree
            int leftPerfectNodes = ((1 << ld) - 1);
            // traverse right
            return leftPerfectNodes + countNodes(root.right) + 1;
        } else { // ld > rd
            // Accumulated a right perfect tree
            int rightPerfectNodes = ((1 << rd) - 1);
            // traverse left
            return rightPerfectNodes + countNodes(root.left) + 1;
        }
    }

    private int leftDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return leftDepth(root.left) + 1;
    }
}
