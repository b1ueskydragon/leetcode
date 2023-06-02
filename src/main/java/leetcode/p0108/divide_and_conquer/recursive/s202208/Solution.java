package leetcode.p0108.divide_and_conquer.recursive.s202208;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        final int m = l + (r - l) / 2;
        final TreeNode root = new TreeNode(nums[m]);

        root.left = sortedArrayToBST(nums, l, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, r);

        return root;
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
