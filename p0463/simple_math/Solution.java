package leetcode.p0463.simple_math;

class Solution {
  public int islandPerimeter(int[][] grid) {
    final int m = grid.length;
    final int n = grid[0].length;
    // number of lands
    int lands = 0;
    // number of adjacent sides
    int adjacent = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1) {
          // check `up`
          if (r > 0 && grid[r - 1][c] == 1) adjacent++;
          // check `left`
          if (c > 0 && grid[r][c - 1] == 1) adjacent++;
          // count up lands anyway
          lands++;
        }
      }
    }
    return 4 * lands - 2 * adjacent;
  }
}
