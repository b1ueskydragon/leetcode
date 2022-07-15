package leetcode.p0200.s202207;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // right, down, left, up
    private final int[] vectorR = {0, 1, 0, -1};
    private final int[] vectorC = {1, 0, -1, 0};

    private int islands = 0;

    public int numIslands(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c]) {
                    continue;
                }
                visitAll(grid, visited, m, n, r, c);
                visited[r][c] = true;
            }
        }
        return islands;
    }

    private void visitAll(char[][] grid,
                          boolean[][] visited,
                          int m, int n,
                          int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }

        final Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{r, c});

        while (!queue.isEmpty()) {
            final int[] curr = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                final int x = curr[0] + vectorR[i];
                final int y = curr[1] + vectorC[i];
                if (isValidPos(x, y, m, n) && !visited[x][y] && grid[x][y] == '1') {
                    queue.addLast(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        islands++;
    }

    private boolean isValidPos(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
