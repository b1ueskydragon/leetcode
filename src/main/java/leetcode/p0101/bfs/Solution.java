package leetcode.p0101.bfs;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int count = queue.size();
            final Integer[] tmp = new Integer[count * 2];
            int i = 0;
            for (int c = 0; c < count; c++) {
                final var parent = queue.poll();
                assert parent != null;
                if (parent.left != null) {
                    queue.offer(parent.left);
                    tmp[i] = parent.left.val;
                }
                i++; // proceed i even if it's null
                if (parent.right != null) {
                    queue.offer(parent.right);
                    tmp[i] = parent.right.val;
                }
                i++; // proceed i even if it's null
            }
            if (!isSymmetric(tmp)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSymmetric(Integer[] xs) {
        int l = 0, r = xs.length - 1;
        while (l <= r) {
            if (!Objects.equals(xs[l], xs[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
