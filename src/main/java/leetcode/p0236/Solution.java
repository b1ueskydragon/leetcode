package leetcode.p0236;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

/**
 * Recursion
 */
public class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    if (root.val == p.val || root.val == q.val) return root;

    TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
    TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

    if (leftChild != null && rightChild != null) return root;

    return leftChild == null ? rightChild : leftChild;
  }

}
