package leetcode.common;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() { /* no-op */ }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * For test codes.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TreeNode otherNode)) {
            return false;
        }

        // Objects.equals(a, b)
        // - Null safe.
        // - If both are non-null, calls a.equals(b).
        // - TreeNode#equals therefore compares child nodes recursively.
        return this.val == otherNode.val
                && Objects.equals(this.left, otherNode.left)
                && Objects.equals(this.right, otherNode.right);
    }

    /**
     * For test codes.
     */
    @Override
    public int hashCode() {
        // This is convenient for tests, but may be expensive for large trees
        // because every hashCode call traverses the whole subtree recursively.
        return Objects.hash(val, left, right);
    }
}
