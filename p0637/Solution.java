package leetcode.p0637;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // first in first out
        final Deque<TreeNode> queue = new ArrayDeque<>();
        final List<Double> averages = new ArrayList<>();
        queue.addLast(root);
        averages.add((double) root.val);
        while (!queue.isEmpty()) {
            double currSum = 0;
            final int currSize = queue.size();
            // control lateral manipulation by for-loop
            for (int i = 0; i < currSize; i++) {
                final TreeNode currRoot = queue.pollFirst();
                if (currRoot == null) {
                    continue;
                }
                if (currRoot.left != null) {
                    currSum += currRoot.left.val;
                    queue.addLast(currRoot.left);
                }
                if (currRoot.right != null) {
                    currSum += currRoot.right.val;
                    queue.addLast(currRoot.right);
                }
            }
            final int newCurrSize = queue.size();
            if (newCurrSize != 0) {
                averages.add(currSum / newCurrSize);
            }
        }
        return averages;
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
