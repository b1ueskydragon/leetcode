package leetcode.p1457.s202209;

import java.util.Arrays;

class Solution {
    private int count = 0;

    // 1 <= node.val <= 9
    // isPalindromic: from the root node to leaf
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return count;
    }

    private void dfs(TreeNode root, int[] prevPath) {
        if (root == null) {
            return;
        }

        // backTracking-ish (make a different choice after return to the root)
        final int[] path = Arrays.copyOf(prevPath, 10);
        path[root.val]++;

        // target of the check (reached to the leaf node)
        if (root.left == null && root.right == null) {
            if (isPalindromic(path)) {
                count++;
            }
        }

        dfs(root.left, path);
        dfs(root.right, path);
    }

    private static boolean isPalindromic(int[] path) {
        int odds = 0;
        for (int freq : path) {
            if (freq % 2 != 0) {
                odds++;
            }
        }
        return odds <= 1;
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
