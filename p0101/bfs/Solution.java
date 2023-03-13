package leetcode.p0101.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int count = queue.size();
            final List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                final var parent = queue.poll();
                if (parent.left != null) {
                    queue.offer(parent.left);
                    tmp.add(parent.left.val);
                } else {
                    tmp.add(null);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                    tmp.add(parent.right.val);
                } else {
                    tmp.add(null);
                }
            }
            if (!isSymmetric(tmp)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSymmetric(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (!Objects.equals(list.get(l), list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
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
