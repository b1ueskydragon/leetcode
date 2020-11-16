package leetcode.p0063.dp;

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    final int m = obstacleGrid.length;
    final int n = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    final int[][] countToReach = new int[m][n]; // dp

    // Accumulation of paths to reach to current point.
    // This will be pass only once. so check whether visited or not is unnecessary.
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (r == 0 && c == 0) {
          countToReach[r][c] = 1;
          continue;
        }
        if (obstacleGrid[r][c] == 1) {
          countToReach[r][c] = 0;
          continue;
        }
        if (r == 0) {
          countToReach[r][c] = countToReach[r][c - 1];
          continue;
        }
        if (c == 0) {
          countToReach[r][c] = countToReach[r - 1][c];
          continue;
        }
        countToReach[r][c] = countToReach[r - 1][c] + countToReach[r][c - 1];
      }
    }
    return countToReach[m - 1][n - 1];
  }
}
