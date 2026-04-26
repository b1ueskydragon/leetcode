package leetcode.p1559;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean containsCycle(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        final int[] dx = {0, 0, 1, -1};
        final int[] dy = {1, -1, 0, 0};

        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start point
                final char value = grid[i][j];
                final Deque<int[]> queue = new ArrayDeque<>();
                queue.addLast(new int[]{i, j, -1, -1});

                while (!queue.isEmpty()) {
                    final int[] curr = queue.pollLast();
                    int r = curr[0];
                    int c = curr[1];
                    int pr = curr[2];
                    int pc = curr[3];

                    if (visited[r][c]) {
                        continue;
                    }
                    visited[r][c] = true;
                    // System.out.printf("%s %s %s %s %n", r, c, pr, pc);

                    for (int k = 0; k < 4; k++) {
                        int x = r + dx[k];
                        int y = c + dy[k];
                        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) {
                            continue;
                        }
                        if (grid[x][y] != value) {
                            continue;
                        }
                        // 自分 (r, c) の子 (x, y) に訪問記録があるのに, 自分の親 (pr, pc) でもなかったら cycle.
                        if (visited[x][y] && !(x == pr && y == pc)) {
                            // System.out.printf("%s %s %s %s %n", x, y, pr, pc);
                            return true;
                        }
                        if (!visited[x][y]) {
                            queue.addLast(new int[]{x, y, r, c});
                        }
                    }

                }

            }
        }
        return false;
    }
}
