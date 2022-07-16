package leetcode.p0695;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // right, down, left, up
    private final int[] vectorR = {0, 1, 0, -1};
    private final int[] vectorC = {1, 0, -1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];
        int maxIsland = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c]) {
                    continue;
                }
                maxIsland = Math.max(maxIsland, getArea(grid, visited, m, n, r, c));
                visited[r][c] = true;
            }
        }
        return maxIsland;
    }

    private int getArea(int[][] grid,
                        boolean[][] visited,
                        int m, int n,
                        int r, int c) {
        if (grid[r][c] == 0) {
            return 0;
        }

        final Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{r, c});
        int island = 0;

        while (!queue.isEmpty()) {
            final int[] curr = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                final int x = curr[0] + vectorR[i];
                final int y = curr[1] + vectorC[i];
                if (isValidPos(x, y, m, n) && !visited[x][y] && grid[x][y] == 1) {
                    queue.addLast(new int[]{x, y});
                    visited[x][y] = true;
                    island++;
                }
            }
        }
        return Math.max(1, island);
    }

    private static boolean isValidPos(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
