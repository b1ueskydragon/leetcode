package leetcode.p0257.hashtable;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private final List<String> res = new ArrayList<>();

  private final Map<TreeNode, String> cache = new HashMap<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return res;
    }

    if (root.left != null) {
      final String acc = cache.getOrDefault(root, String.valueOf(root.val)) + "->" + root.left.val;
      cache.put(root.left, acc);
    }
    binaryTreePaths(root.left);

    if (root.right != null) {
      final String acc = cache.getOrDefault(root, String.valueOf(root.val)) + "->" + root.right.val;
      cache.put(root.right, acc);
    }
    binaryTreePaths(root.right);

    if (root.left == null && root.right == null) {
      res.add(cache.getOrDefault(root, String.valueOf(root.val)));
    }

    return res;
  }

}
