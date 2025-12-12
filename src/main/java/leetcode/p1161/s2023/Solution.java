package leetcode.p1161.s2023;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return 1;
        }
        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int maxSum = root.val;
        int cand = 1;
        int level = 2;
        while (!queue.isEmpty()) {
            int currSum = 0;
            final int currParentsNum = queue.size();
            for (int i = 0; i < currParentsNum; i++) {
                final var parent = queue.pollFirst();
                final var left = parent.left;
                final var right = parent.right;
                if (left != null) {
                    queue.addLast(left);
                    currSum += left.val;
                }
                if (right != null) {
                    queue.addLast(right);
                    currSum += right.val;
                }
            }
            if (queue.size() == 0) {
                return cand;
            }
            if (maxSum < currSum) {
                maxSum = currSum;
                cand = level;
            }
            level++;
        }
        return cand;
    }
}
