package leetcode.p0865;

import leetcode.common.TreeNode;

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getDeepestRoot(root, 0).node;
    }

    // Propagate parent's information to its children: level
    // Sum up children's information to its parent: the deepest root
    private Pair getDeepestRoot(TreeNode curr, int level) {
        if (curr == null) {
            return null; // Nothing to return.
        }
        if (curr.left == null && curr.right == null) {
            return new Pair(curr, level); // The deepest root.
        }

        Pair leftCand = getDeepestRoot(curr.left, level + 1);
        Pair rightCand = getDeepestRoot(curr.right, level + 1);

        if (leftCand == null) {
            return rightCand;
        }
        if (rightCand == null) {
            return leftCand;
        }

        // System.out.printf("left: %s (%s) right: %s (%s) %n",
        // leftCand.node.val, leftCand.level, rightCand.node.val, rightCand.level);

        if (leftCand.level > rightCand.level) {
            return leftCand;
        }
        if (leftCand.level < rightCand.level) {
            return rightCand;
        }
        // To compare to its upper level properly, take over its children's level in advance.
        return new Pair(curr, leftCand.level); // rightCand.level is OK also.
    }

    private static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
