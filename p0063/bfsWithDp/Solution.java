package leetcode.p0063.bfsWithDp;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    final int m = obstacleGrid.length;
    final int n = obstacleGrid[0].length;

    if (m == 1 && n == 1) {
      return 1;
    }

    final Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(0, 0)); // start point

    final boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;

    final int[][] countToReach = new int[m][n];

    final int[][] vectors = {{0, 1}, {1, 0}}; // go right, go down

    while (!queue.isEmpty()) {
      final Point curr = queue.poll();
      final int currX = curr.getX();
      final int currY = curr.getY();

      for (int[] vector : vectors) {
        final int r = vector[0];
        final int c = vector[1];

        final int nextX = currX + r;
        final int nextY = currY + c;

        if (nextX >= m ||
            nextY >= n ||
            visited[nextX][nextY] ||
            obstacleGrid[nextX][nextY] == 1) {
          continue;
        }

        visited[nextX][nextY] = true;
        queue.add(new Point(nextX, nextY));

        // count to reach prev Up + count to reach prev Left
        countToReach[nextX][nextY] = (nextX >= 1 && nextY >= 1) ?
            countToReach[nextX - 1][nextY] + countToReach[nextX][nextY - 1] : 1;
      }
    }

    return countToReach[m - 1][n - 1];
  }

  private static class Point {
    private final int x;
    private final int y;

    Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    int getX() {
      return x;
    }

    int getY() {
      return y;
    }
  }
}
