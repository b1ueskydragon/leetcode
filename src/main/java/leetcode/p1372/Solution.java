package leetcode.p1372;

import leetcode.common.TreeNode;

class Solution {

    int globalMax = 0;

    public int longestZigZag(TreeNode root) {
        zigZagDfs(root, true, 0);
        return globalMax;
    }

    private void zigZagDfs(TreeNode node, boolean goLeft, int length) {
        if (node == null) {
            return;
        }

        globalMax = Math.max(globalMax, length);

        if (goLeft) {
            zigZagDfs(node.left, false, length + 1);
            // Root is reset, reset the length.
            // node (parent or root) 一回戻さずにそのまま node.right に飛ばすので 0 ではなく 1 として reset.
            zigZagDfs(node.right, true, 1);
        } else {
            zigZagDfs(node.right, true, length + 1);
            // Root is reset, reset the length.
            zigZagDfs(node.left, false, 1);
        }

    }
}
