package leetcode.p1123;

class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    return getLca(root, 0).getNode();
  }

  private Pair getLca(TreeNode node, int level) {
    if (node == null) {
      return new Pair(null, level);
    }
    Pair leftPair = getLca(node.left, level + 1);
    Pair rightPair = getLca(node.right, level + 1);

    // getting out from the recursion and current node is parent.
    if (leftPair.getDepth() == rightPair.getDepth()) {
      return new Pair(node, leftPair.getDepth());
    }

    // compare each step of result and node of the step, after returned from recursions.
    return (leftPair.getDepth() > rightPair.getDepth()) ? leftPair : rightPair;
  }

  private static class Pair {
    private TreeNode node;
    private int depth;

    Pair(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }

    public TreeNode getNode() {
      return node;
    }

    public int getDepth() {
      return depth;
    }
  }

}
