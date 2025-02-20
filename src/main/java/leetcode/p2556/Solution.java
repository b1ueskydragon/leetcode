package leetcode.p2556;

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // 1->0 反転しなくても元々がたどり着けないケース
        boolean[][] isReachable = new boolean[m][n];
        updateReachability(grid, 0, 0, isReachable);
        if (!isReachable[m - 1][n - 1]) {
            return true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (!(i == 0 && j == 0) && !(i == m - 1 && j == n - 1))) {
                    grid[i][j] = 0;
                    // reachability from grid[0][0] to each grid[i][j]
                    isReachable = new boolean[m][n];
                    updateReachability(grid, 0, 0, isReachable);
                    if (!isReachable[m - 1][n - 1]) {
                        return true; // 断てた
                    }
                    // 次の attempt のために元に戻す
                    grid[i][j] = 1;
                }
            }
        }
        // return false menas paths are cannot be disconnected
        // in other words, at least one path can reach to grid[m-1][n-1]
        return false;
    }

    private void updateReachability(int[][] grid, int i, int j, boolean[][] cache) {
        // already visited
        if (cache[i][j]) {
            return;
        }
        // grid[i-1][j] == 1 or grid[i][j-1] == 1 の場合のみ次に行ける (深く入って来れる)
        if (grid[i][j] == 1) {
            cache[i][j] = true;
            if (i < grid.length - 1) {
                updateReachability(grid, i + 1, j, cache);
            }
            if (j < grid[0].length - 1) {
                updateReachability(grid, i, j + 1, cache);
            }
        }
    }
}
