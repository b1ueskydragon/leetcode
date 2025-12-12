package leetcode.p0103;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution2025 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        final List<List<Integer>> answer = new ArrayList<>();
        final Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);

        boolean flipped = false;
        while (!dq.isEmpty()) {
            final int n = dq.size();
            final LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                final TreeNode node = dq.pollFirst();

                if (flipped) {
                    tmp.addFirst(node.val);
                } else {
                    tmp.addLast(node.val);
                }

                if (node.left != null) {
                    dq.addLast(node.left);
                }
                if (node.right != null) {
                    dq.addLast(node.right);
                }
            }
            answer.add(tmp);
            flipped = !flipped;
        }

        return answer;
    }
}
