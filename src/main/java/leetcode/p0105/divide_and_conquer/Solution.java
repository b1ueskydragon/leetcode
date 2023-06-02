package leetcode.p0105.divide_and_conquer;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private final Map<Integer, Integer> table = new HashMap<>();

    // index of a preorder array
    private int i = 0;

    // values are unique
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            table.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, inorder, preorder);
    }

    private TreeNode build(int l, int r, // indices of inorder
                           int[] inorder, int[] preorder) {
        // nothing to append
        if (i == preorder.length) {
            return null;
        }
        // nothing to append
        if (l > r) {
            return null;
        }

        // divide phase
        int headVal = preorder[i++]; // to get a current head, proceed an index of the preorder array for each recursion

        var head = new TreeNode(headVal);
        int h = table.get(headVal); // index of the inorder array

        var left = build(l, h - 1, inorder, preorder);
        var right = build(h + 1, r, inorder, preorder);

        // conquer phase
        if (left != null) head.left = left;
        if (right != null) head.right = right;

        return head;
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
