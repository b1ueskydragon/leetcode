package leetcode.p0337;

import leetcode.common.TreeNode;

class Solution {
    public int rob(TreeNode root) {
        Status status = dfs(root);
        return Math.max(status.inclThis, status.exclThis);
    }

    // Propagate the children's status to its parent node recursively
    private Status dfs(TreeNode root) {
        if (root == null) {
            // Sums of base case are both 0
            return Status.of(0, 0);
        }

        // Go deeper first (Get the status of children first, then compute its parent)

        final Status left = dfs(root.left);
        final Status right = dfs(root.right);

        // Then collect (compute) the result

        // Include current node
        // Note: This can take over its children-excluded results
        final int inclCurr = root.val + left.exclThis + right.exclThis;

        // Exclude current node (maybe include its children)
        // Note:
        // - This also can take over its children-excluded results, to choose the better combination of child states
        // - We don't need to pick both children everytime
        // final int getBoth = left.inclThis + right.inclThis;
        // final int getNone = left.exclThis + right.exclThis;
        // final int getLeft = left.inclThis + right.exclThis;
        // final int getRight = left.exclThis + right.inclThis;
        // final int exclCurr = Math.max(Math.max(getBoth, getNone), Math.max(getLeft, getRight));
        final int exclCurr = Math.max(left.inclThis, left.exclThis) + Math.max(right.inclThis, right.exclThis);

        return Status.of(inclCurr, exclCurr);
    }

    private static class Status {
        int inclThis;
        int exclThis;

        private Status(int inclThis, int exclThis) {
            this.inclThis = inclThis;
            this.exclThis = exclThis;
        }

        private static Status of(int inclThis, int exclThis) {
            return new Status(inclThis, exclThis);
        }
    }
}
