package leetcode.p0022.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // Constraints 1<= n <= 8. DFS|Backtracking could be a tolerable choice.
  public List<String> generateParenthesis(int n) {
    return generateParenthesis(n, n, new ArrayList<>(), "");
  }

  private List<String> generateParenthesis(final int leftRemain,
                                           final int rightRemain,
                                           final List<String> result,
                                           final String node) {
    // base case to append to outer result.
    // since `open first`, checking leftRemain == 0 is redundant.
    if (rightRemain == 0) {
      result.add(node);
      return result;
    }

    // open first as much as we can.
    if (leftRemain > 0) {
      generateParenthesis(leftRemain - 1, rightRemain, result, node + "(");
    }

    // only can close as much as opened before.
    // e.g. "((" can append both "(" and ")", but "()" can't append ")"
    if (leftRemain < rightRemain && rightRemain > 0) {
      generateParenthesis(leftRemain, rightRemain - 1, result, node + ")");
    }

    return result;
  }
}
