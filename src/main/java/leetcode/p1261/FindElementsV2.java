package leetcode.p1261;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
class FindElementsV2 {

  private final Set<Integer> valueSet;

  // Initializes the object with a contaminated binary tree and recovers it.
  public FindElementsV2(TreeNode root) {
    this.valueSet = new HashSet<>();
    final Deque<TreeNode> queue = new ArrayDeque<>();
    root.val = 0; // start point
    queue.addLast(root); // we will change root in-place
    while (!queue.isEmpty()) {
      TreeNode parent = queue.pollFirst();
      this.valueSet.add(parent.val);
      if (parent.left != null) {
        parent.left.val = parent.val * 2 + 1;
        queue.addLast(parent.left); // next parent 1
      }
      if (parent.right != null) {
        parent.right.val = parent.val * 2 + 2;
        queue.addLast(parent.right); // next parent 2
      }
    }
  }

  // Returns true if the target value exists in the recovered binary tree.
  // Constraints: At most 10^4 calls
  public boolean find(int target) {
    return this.valueSet.contains(target);
  }
}
