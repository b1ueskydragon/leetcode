package leetcode.p0062.bfs;

class Solution {
  public int uniquePaths(int m, int n) {
    // accumulated count to reach the point so far
    final int[][] steps = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // If encounter the edge, put 1. others, prevUp + prevLeft
        steps[i][j] = (i == 0 || j == 0) ? 1 : steps[i - 1][j] + steps[i][j - 1];
      }
    }
    return steps[m - 1][n - 1];
  }
}
