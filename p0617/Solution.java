package leetcode.p0617;

import java.util.Deque;
import java.util.LinkedList;

// create a new merged tree.
public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    final Deque<TreeNode> retrieval1 = new LinkedList<>();
    final Deque<TreeNode> retrieval2 = new LinkedList<>();
    retrieval1.addLast(t1);
    retrieval2.addLast(t2);
    final Deque<Integer> merged = new LinkedList<>();
    while (!retrieval1.isEmpty() || !retrieval2.isEmpty()) {
      TreeNode r1 = null;
      TreeNode r2 = null;
      if (!retrieval1.isEmpty()) r1 = retrieval1.removeFirst();
      if (!retrieval2.isEmpty()) r2 = retrieval2.removeFirst();
      if (r1 == null && r2 == null) {
        merged.addLast(null);
        continue;
      }
      int currVal = 0;
      TreeNode r1Left, r1Right, r2Left, r2Right;
      // just pointing null at first, not a instantiation of mutable object, so it's OK.
      r1Left = r1Right = r2Left = r2Right = null;
      if (r1 != null) {
        r1Left = r1.left;
        r1Right = r1.right;
        currVal += r1.val;
      }
      if (r2 != null) {
        r2Left = r2.left;
        r2Right = r2.right;
        currVal += r2.val;
      }
      retrieval1.addLast(r1Left);
      retrieval1.addLast(r1Right);
      retrieval2.addLast(r2Left);
      retrieval2.addLast(r2Right);
      merged.addLast(currVal);
    }

    final TreeNode root = new TreeNode(merged.removeFirst());
    final Deque<TreeNode> marked = new LinkedList<>();
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
