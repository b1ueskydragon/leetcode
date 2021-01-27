package leetcode.p0606.dfs;

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

class Solution {
  public String tree2str(TreeNode t) {
    return tree2str(t, new StringBuilder()).toString();
  }

  private StringBuilder tree2str(TreeNode t, StringBuilder str) {
    if (t == null) {
      return str;
    }

    str.append(t.val);

    // offer an empty pair if left node is null but right node exists
    if (t.left != null || t.right != null) {
      // open before enter the recursion
      str.append("(");
      tree2str(t.left, str);
      // close after get out from the recursion
      str.append(")");
    }

    // right node doesn't care the left, since the left is already checked
    if (t.right != null) {
      str.append("(");
      tree2str(t.right, str);
      str.append(")");
    }

    return str;
  }
}
