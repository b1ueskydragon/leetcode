package leetcode.p1391;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // (0, 0) to (m - 1, n -1) startが 決まっている.
        // multi-source bfs ではない.
        // cycle 検出でもないので parent tracking も不要.
        // reachability, visited 判断で十分.
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});

        final int[] dx = {0, 0, 1, -1};
        final int[] dy = {1, -1, 0, 0};

        final boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            final int[] curr = queue.pollLast();
            final int r = curr[0];
            final int c = curr[1];

            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            // System.out.printf("%s %s %n", r, c);

            for (int k = 0; k < 4; k++) {
                final int x = r + dx[k];
                final int y = c + dy[k];

                if (x < 0 || y < 0 || x > m - 1 || y > n - 1) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                if (isConnected(grid, r, c, x, y)) {
                    // System.out.printf("%s %s -> %s %s %n", r, c, x, y);
                    queue.addLast(new int[]{x, y});
                }
            }
        }
        return visited[m - 1][n - 1];
    }

    // valid pattern of (r, c) -> (x, y)
    private boolean isConnected(int[][] grid, int r, int c, int x, int y) {
        // u -> v
        final int u = grid[r][c];
        final int v = grid[x][y];
        if (r == x) {
            if (u == 1) {
                return v == 1 || v == 3 || v == 5;
            }
            if (u == 3) {
                return v == 1 || v == 4 || v == 6;
            }
            if (u == 4) {
                return v == 1 || v == 3 || v == 5;
            }
            if (u == 5) {
                return v == 1 || v == 4 || v == 6;
            }
            if (u == 6) {
                return v == 1 || v == 3 || v == 5;
            }
        }
        if (c == y) {
            if (u == 2) {
                return v == 2 || v == 5 || v == 6;
            }
            if (u == 3) {
                return v == 2 || v == 5 || v == 6;
            }
            if (u == 4) {
                return v == 2 || v == 5 || v == 6;
            }
            if (u == 5) {
                return v == 2 || v == 3 || v == 4;
            }
            if (u == 6) {
                return v == 2 || v == 3 || v == 4;
            }
        }
        return false;
    }
}
