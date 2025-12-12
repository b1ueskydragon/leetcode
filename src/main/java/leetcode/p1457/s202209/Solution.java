package leetcode.p1457.s202209;

import leetcode.common.TreeNode;

import java.util.Arrays;

class Solution {
    // 1 <= node.val <= 9
    private static final int LIMIT = 10;

    // isPalindromic: from the root node to leaf
    public int pseudoPalindromicPaths(TreeNode root) {
        return count(root, new int[LIMIT]);
    }

    private static int count(TreeNode root, int[] prevPath) {
        if (root == null) {
            return 0;
        }
        // backTracking-ish (make a different choice after return to the root)
        // to keep the current immutable path for each root
        final int[] path = Arrays.copyOf(prevPath, LIMIT);
        path[root.val]++;

        // target of the check (reached to the leaf node)
        if (root.left == null && root.right == null) {
            if (isPalindromic(path)) {
                return 1;
            }
        }
        // left acc + right acc
        return count(root.left, path) + count(root.right, path);
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
