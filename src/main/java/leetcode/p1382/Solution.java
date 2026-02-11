package leetcode.p1382;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        serialize(root, sorted);
        return build(sorted, 0, sorted.size() - 1);
    }

    // In-order traversal (left -> root -> right)
    // Given root is BST, additional sorting won't be required.
    private static void serialize(TreeNode root, List<Integer> sorted) {
        if (root == null) {
            return;
        }
        serialize(root.left, sorted);
        sorted.add(root.val);
        serialize(root.right, sorted);
    }

    // root = build from left-aligned center
    // e.g.,
    // [1, 2]
    // [ (1 root), (2 right) ]
    //
    // [1, 2, 3]
    // [ (1 left), (2 root), (3 right) ]
    //
    // [1, 2, 3, 4, 5]
    // [         (1, 2 left),          (3 root),         (4, 5 right) ]
    // [ ((1 root), (2 right) left),   (3 root),   ((4 root), (5 right) right) ]
    private static TreeNode build(List<Integer> sorted, int l, int r) {
        if (l > r) {
            return null;
        }

        // left-aligned center
        final int m = l + (r - l) / 2;
        // build new tree (root)
        TreeNode root = new TreeNode(sorted.get(m));
        // build left
        TreeNode left = build(sorted, l, m - 1);
        // build right
        TreeNode right = build(sorted, m + 1, r);

        root.left = left;
        root.right = right;

        return root;
    }
}
