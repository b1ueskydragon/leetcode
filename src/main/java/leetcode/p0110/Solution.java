package leetcode.p0110;

import leetcode.common.TreeNode;

class Solution {

    static class V2 {

        public boolean isBalanced(TreeNode root) {
            // 下から上に状態 (level) を伝播する.
            return dfs(root) != -1;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSoFar = dfs(root.left);
            if (leftSoFar == -1) {
                return -1;
            }

            int rightSoFar = dfs(root.right);
            if (rightSoFar == -1) {
                return -1;
            }

            int left = leftSoFar + 1;
            int right = rightSoFar + 1;

            return (Math.abs(left - right) <= 1) ? Math.max(left, right) : -1;
        }

    }

    static class V1 {

        public boolean isBalanced(TreeNode root) {
            // 下から上に状態 (level) を伝播する.
            dfs(root);
            return isBalanced;
        }

        boolean isBalanced = true;

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left) + 1;
            int right = dfs(root.right) + 1;
            // System.out.printf("%s, %s %n", left, right);
            isBalanced &= (Math.abs(left - right) <= 1);
            return Math.max(left, right);
        }

    }

}
