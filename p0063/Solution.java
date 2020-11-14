package leetcode.p0063;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    final Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(0, 0)); // start point

    final int m = obstacleGrid.length;
    final int n = obstacleGrid[0].length;

//         final boolean[][] visited = new boolean[m][n];
//         visited[0][0] = true;

//         final List<Point> paths = new ArrayList<>();

    final int[][] vectors = {{0, 1}, {1, 0}}; // go right, go down

    while (!queue.isEmpty()) {
      final Point curr = queue.poll();
      final int currX = curr.getX();
      final int currY = curr.getY();

      if (currX == m - 1 && currY == n - 1) {
        queue.offer(curr);
        break;
      }

      for (int[] vector : vectors) {
        final int r = vector[0];
        final int c = vector[1];

        final int nextX = currX + r;
        final int nextY = currY + c;

        if (nextX >= m ||
            nextY >= n ||
            //visited[nextX][nextY] ||
            obstacleGrid[nextX][nextY] == 1) {
          continue;
        }

        // visited[nextX][nextY] = true;
        final Point nextPoint = new Point(nextX, nextY);
        queue.add(nextPoint);

        // paths.add(nextPoint);
      }
    }

//         System.out.println(paths);

//         for (boolean[] visit : visited) {
//             for (boolean b: visit) {
//                 System.out.printf("%s, ", b);
//             }
//             System.out.println();
//         }

    return queue.size();
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

    // @Override
    // public String toString() {
    //     return String.format("(%s, %s)", x, y);
    // }
  }
}
