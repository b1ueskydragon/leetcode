package leetcode.p0077;

import java.util.ArrayList;
import java.util.List;

class Solution {
  /**
   * @param n [1, n]
   * @param k combinations of k numbers
   */
  public List<List<Integer>> combine(int n, int k) {
    return combine(n, k, 1, new ArrayList<>(), new ArrayList<>());
  }

  // backtracking
  private List<List<Integer>> combine(final int n,
                                      final int k,
                                      final int level,
                                      final List<Integer> node,
                                      final List<List<Integer>> res) {
    if (k == 0) { // base case
      res.add(node);
      return res;
    }

    for (int i = level; i <= n; i++) {
      final List<Integer> newNode = new ArrayList<>(node);
      newNode.add(i);
      combine(n, k - 1, i + 1, newNode, res); // skip previous numbers. start from next level (i + 1)
    }
    return res;
  }
}
