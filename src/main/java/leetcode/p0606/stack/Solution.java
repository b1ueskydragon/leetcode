package leetcode.p0606.stack;

import leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
  public String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }

    final StringBuilder builder = new StringBuilder();
    // push right to left
    final Stack<TreeNode> stack = new Stack<>();
    final Set<TreeNode> appended = new HashSet<>();
    stack.push(t);

    while (!stack.isEmpty()) {
      final TreeNode curr = stack.peek();
      if (appended.contains(curr)) {
        stack.pop();
        builder.append(")"); // close (and pop) after finally returned to original position
        continue;
      }

      builder.append("(");
      builder.append(curr.val);
      appended.add(curr);

      if (curr.left == null && curr.right != null) {
        builder.append("()");
      }

      if (curr.right != null) {
        stack.push(curr.right);
      }

      if (curr.left != null) {
        stack.push(curr.left);
      }
    }

    final String str = builder.toString();
    return str.substring(1, str.length() - 1);
  }
}
