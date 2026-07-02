package leetcode.p3286;

import java.util.ArrayDeque;
import java.util.List;

class Solution {
    // 4 neighbors --> prefix-sum isn't enough.
    // Fixed single start point from (0, 0) --> single-source BFS.
    // Allow revisit conditionally --> simple boolean check isn't enough, DP-ish check is needed.
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        final int m = grid.size();
        final int n = grid.get(0).size();

        // [0]: i, [1]: j, [2]: cost
        final ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0, grid.get(0).get(0)});

        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};

        // MinCost so far to reach that cell.
        final int[][] minCost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {
            final int[] parent = queue.pollLast();
            final int r = parent[0];
            final int c = parent[1];
            final int cost = parent[2]; // Equivalent to minCost[r][c] at this point.
            if (r == m - 1 && c == n - 1 && cost <= health) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                final int nr = r + dx[i];
                final int nc = c + dy[i];
                if (nr >= m || nr < 0 || nc >= n || nc < 0) {
                    continue;
                }
                final int costSoFar = cost + grid.get(nr).get(nc);
                // You can move up, down, left, or right from one cell to another adjacent cell
                // as long as your health remains positive.
                if (costSoFar >= health) {
                    continue;
                }
                // Simple `visited` check is not enough.
                // Allow to revisit only the new accumulated cost is smaller than the previous path's cost.
                // Otherwise, discard.
                if (costSoFar >= minCost[nr][nc]) {
                    continue;
                }
                minCost[nr][nc] = Math.min(minCost[nr][nc], costSoFar);
                queue.addLast(new int[]{nr, nc, minCost[nr][nc]});
            }
        }

        return false;
    }
}
