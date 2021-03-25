package leetcode.p0062.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int uniquePaths(int m, int n) {
    final Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(0, 0));

    // vectors
    final int[] goRight = {0, 1};
    final int[] goDown = {1, 0};

    int count = 0;

    while (!queue.isEmpty()) {
      final var parent = queue.poll();
      final int x = parent.m;
      final int y = parent.n;

      if (x >= m || y >= n) {
        continue;
      }

      // encounter the Finish
      if (x == m - 1 && y == n - 1) {
        count++;
      }

      queue.add(new Point(x + goRight[0], y + goRight[1]));
      queue.add(new Point(x + goDown[0], y + goDown[1]));
    }

    return count;
  }

  static class Point {
    int m;
    int n;

    Point(int m, int n) {
      this.m = m;
      this.n = n;
    }
  }
}
