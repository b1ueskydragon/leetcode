package leetcode.p1161;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2026 implements Solution {

    public int maxLevelSum(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        int ans = 1;
        int maxSum = root.val;
        while (!queue.isEmpty()) {
            depth++;
            int sum = 0;
            // Traverse all children at that level
            int nodes = queue.size();
            for (int i = 0; i < nodes; i++) {
                var p = queue.pollFirst();
                sum += p.val;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = depth;
            }
        }
        return ans;
    }

}
