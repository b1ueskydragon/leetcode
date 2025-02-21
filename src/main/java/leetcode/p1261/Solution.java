package leetcode.p1261;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
class FindElements {

    private final TreeNode root;

    // Initializes the object with a contaminated binary tree and recovers it.
    public FindElements(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>();
        root.val = 0; // start point
        queue.addLast(root); // we will change root in-place
        while (!queue.isEmpty()) {
            TreeNode parent = queue.pollFirst();
            if (parent.left != null) {
                parent.left.val = parent.val * 2 + 1;
                queue.addLast(parent.left); // next parent 1
            }
            if (parent.right != null) {
                parent.right.val = parent.val * 2 + 2;
                queue.addLast(parent.right); // next parent 2
            }
        }
        this.root = root;
    }

    // Returns true if the target value exists in the recovered binary tree.
    // Constraints: At most 10^4 calls
    public boolean find(int target) {
        // odd -> left, even -> right
        return findDepth(this.root, target, false);
    }

    private boolean findDepth(TreeNode root, int target, boolean found) {
        if (root == null) {
            // we don't know true or false at this point, so just return passed found
            return found;
        }
        if (root.val == target) {
            return true;
        }
        // 一つでも見つかれば true なので OR
        return findDepth(root.left, target, found) || findDepth(root.right, target, found);
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
