package leetcode.p0623.dfs;

import leetcode.common.TreeNode;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRow(root, val, depth, false);
    }

    private static TreeNode addOneRow(TreeNode root,
                                      int val,
                                      int depth,
                                      boolean isRight) {
        // base case

        if (depth == 1) {
            final var node = new TreeNode(val);
            if (isRight) {
                node.right = root;
            } else {
                node.left = root;
            }
            return node;
        }

        // recursive case

        // if the current root is null, do nothing and just return the root
        if (root != null) {
            root.left = addOneRow(root.left, val, depth - 1, false);
            root.right = addOneRow(root.right, val, depth - 1, true);
        }
        return root;
    }
}
