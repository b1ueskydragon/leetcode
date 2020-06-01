package leetcode.p0617;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) { this.val = val; }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;

    Deque<TreeNode> retrieval1 = new LinkedList<>();
    Deque<TreeNode> retrieval2 = new LinkedList<>();
    retrieval1.addLast(t1);
    retrieval2.addLast(t2);

    Deque<Integer> merged = new LinkedList<>();
    while (!retrieval1.isEmpty() || !retrieval2.isEmpty()) {
      TreeNode r1 = null;
      TreeNode r2 = null;
      if (!retrieval1.isEmpty()) r1 = retrieval1.removeFirst();
      if (!retrieval2.isEmpty()) r2 = retrieval2.removeFirst();
      if (r1 == null && r2 == null) {
        merged.addLast(null);
        continue;
      }
      if (r2 == null) {
        merged.addLast(r1.val);
        retrieval1.addLast(r1.left);
        retrieval1.addLast(r1.right);
        retrieval2.addLast(null);
        retrieval2.addLast(null);
      } else if (r1 == null) {
        merged.addLast(r2.val);
        retrieval2.addLast(r2.left);
        retrieval2.addLast(r2.right);
        retrieval1.addLast(null);
        retrieval1.addLast(null);
      } else {
        merged.addLast(r1.val + r2.val);
        retrieval1.addLast(r1.left);
        retrieval1.addLast(r1.right);
        retrieval2.addLast(r2.left);
        retrieval2.addLast(r2.right);
      }
    }

    TreeNode root = new TreeNode(merged.removeFirst());
    Deque<TreeNode> marked = new LinkedList<>();
    marked.addLast(root);
    while (!merged.isEmpty() && !marked.isEmpty()) {
      TreeNode curr = marked.removeFirst();
      Integer leftVal = merged.removeFirst();
      Integer rightVal = merged.removeFirst();
      if (leftVal != null) {
        curr.left = new TreeNode(leftVal);
        marked.addLast(curr.left);
      }
      if (rightVal != null) {
        curr.right = new TreeNode(rightVal);
        marked.addLast(curr.right);
      }
    }

    return root;
  }
}
