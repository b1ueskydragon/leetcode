package leetcode.p2196;

import leetcode.common.TreeNode;

class Solution {
    // Unique values.
    // 1 <= value <= 100_000
    public TreeNode createBinaryTree(int[][] descriptions) {
        // root -> Tree(root, left, right)
        // e.g.,
        // descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
        // 20 -> Tree(20, 15, 17)
        // 50 -> Tree(50, 20, 80)
        // 80 -> Tree(80, 19, null)
        final int limit = 100_001;
        final TreeNode[] flatten = new TreeNode[limit];
        // Initialization as zero is fine due to the constraint.
        final int[] childToParent = new int[limit];
        for (int[] tuple : descriptions) {
            final var rootVal = tuple[0];
            final var childVal = tuple[1];
            final boolean isLeft = tuple[2] == 1;

            childToParent[childVal] = rootVal;

            // If not exists yet, create it.
            if (flatten[rootVal] == null) {
                flatten[rootVal] = new TreeNode(rootVal);
            }
            if (flatten[childVal] == null) {
                flatten[childVal] = new TreeNode(childVal);
            }

            // Connect child and its parent.
            if (isLeft) {
                flatten[rootVal].left = flatten[childVal];
            } else {
                flatten[rootVal].right = flatten[childVal];
            }
        }

        // Find a root.
        for (int[] tuple : descriptions) {
            final var rootVal = tuple[0];
            if (childToParent[rootVal] == 0) {
                return flatten[rootVal];
            }
        }

        return null;
    }
}
