package leetcode.p0200.s202007;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
  public int numIslands(char[][] grid) {
    final int rowDim = grid.length;
    if (rowDim == 0) return 0;
    final int colDim = grid[0].length;
    final boolean[][] visited = new boolean[rowDim][colDim];

    int islands = 0;
    for (int x = 0; x < rowDim; x++) {
      for (int y = 0; y < colDim; y++) {
        if (grid[x][y] == '1' && !visited[x][y]) { // skip count if visited
          visit(grid, rowDim, colDim, x, y, visited);
          islands++;
        }
      }
    }
    return islands;
  }

  // color the visited spot to prevent duplicated count.
  private void visit(char[][] grid, int rowDim, int colDim, int currX, int currY, boolean[][] visited) {
    final Deque<int[]> queue = new LinkedList<>();
    final int[] start = {currX, currY};
    queue.addLast(start);

    // right, down, left, up
    final int[] moveRow = {0, 1, 0, -1};
    final int[] moveCol = {1, 0, -1, 0};
    while (!queue.isEmpty()) {
      int[] parent = queue.pollFirst();
      int row = parent[0];
      int col = parent[1];
      for (int i = 0; i < 4; i++) {
        int childRow = row + moveRow[i];
        int childCol = col + moveCol[i];

        if (childRow >= rowDim || childCol >= colDim) continue;
        if (childRow < 0 || childCol < 0) continue;
        if (visited[childRow][childCol]) continue;
        visited[childRow][childCol] = true;

        if (grid[childRow][childCol] == '1') { // only put the next if grid is island
          int[] next = {childRow, childCol};
          queue.addLast(next);
        }
      }
    }
  }
}
