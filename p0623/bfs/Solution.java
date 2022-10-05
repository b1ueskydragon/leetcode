package leetcode.p0623.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            final var top = new TreeNode(val);
            top.left = root;
            return top;
        }

        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int currDepth = 0;

        while (!queue.isEmpty()) {
            final boolean shouldAdd = ++currDepth == depth - 1;
            final int parents = queue.size();

            for (int i = 0; i < parents; i++) {
                final var parent = queue.poll();
                final var left = parent.left;
                final var right = parent.right;

                if (shouldAdd) {
                    parent.left = new TreeNode(val);
                    parent.left.left = left;

                    parent.right = new TreeNode(val);
                    parent.right.right = right;
                }

                if (left != null) {
                    queue.offer(left);
                }

                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
