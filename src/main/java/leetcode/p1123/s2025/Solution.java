package leetcode.p1123.s2025;

import leetcode.common.TreeNode;

class Solution {
    // Note:
    // Only one deepest leaf -> The leaf itself is a LCA
    // Multiple deepest leaves -> Their common ancestor is a LCA
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).lca;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(root, 0);
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        // Already retrieved both left and right,
        // and has returned to the node

        // Left's result is deeper. Take over left's result
        if (leftRes.level > rightRes.level) {
            return new Result(leftRes.lca, leftRes.level + 1);
        }

        // Right's result is deeper. Take over right's result
        if (rightRes.level > leftRes.level) {
            return new Result(rightRes.lca, rightRes.level + 1);
        }

        // leftLca.level == rightLca.level
        // We need to take both, and the node should be a common ancestor
        return new Result(root, leftRes.level + 1);
    }

    // We don't care the result is from left or right
    // Just take over the previous result
    private static class Result {
        // This will keep current lca
        TreeNode lca;
        // This indicates the depth of the deepest leaf in this subtree
        // +1 each time as we return from children back to parent
        int level;

        Result(TreeNode lca, int level) {
            this.lca = lca;
            this.level = level;
        }
    }
}
