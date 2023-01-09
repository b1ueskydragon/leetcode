package leetcode.p0144;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // pre-order: root is a head
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    private static List<Integer> preorderTraversal(TreeNode root, List<Integer> preOrder) {
        if (root == null) {
            return preOrder;
        }
        preOrder.add(root.val);
        preorderTraversal(root.left, preOrder);
        preorderTraversal(root.right, preOrder);
        return preOrder;
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
