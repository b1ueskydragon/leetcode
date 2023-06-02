package leetcode.p0897;

class Solution {
    // Separated from recursion processing.
    private static TreeNode newRoot = new TreeNode();

    // Binary "Search" Tree. Using it's sorted property.
    // Every node should have no left child and only one right child.
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = newRoot;
        inOrderTraversal(root);
        return head.right;
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        // Append at here.
        newRoot.right = new TreeNode(root.val);
        newRoot = newRoot.right;
        inOrderTraversal(root.right);
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
