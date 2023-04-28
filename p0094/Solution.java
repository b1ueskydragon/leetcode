package leetcode.p0094;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new LinkedList<>());
    }

    private static List<Integer> inorderTraversal(TreeNode root, List<Integer> xs) {
        if (root == null) {
            return xs;
        }
        inorderTraversal(root.left, xs);
        xs.add(root.val);
        inorderTraversal(root.right, xs);
        return xs;
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
