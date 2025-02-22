package leetcode.p2556;

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // 1->0 反転しなくても元々がたどり着けないケース
        boolean[][] isReachableWithoutFlip = new boolean[m][n];
        updateReachability(grid, 0, 0, isReachableWithoutFlip);
        if (!isReachableWithoutFlip[m - 1][n - 1]) {
            return true;
        }

        // 1回目の dfs で grid を変えてしまったので start, end をリセットしてあげる
        grid[0][0] = 1;
        grid[m - 1][n - 1] = 1;

        boolean[][] isReachable = new boolean[m][n];
        updateReachability(grid, 0, 0, isReachable);
        // return false means paths are cannot be disconnected
        // in other words, at least one path can reach to grid[m-1][n-1]
        return !isReachable[m - 1][n - 1];
    }

    private void updateReachability(int[][] grid, int i, int j, boolean[][] visited) {
        // 最大1つ見つかれば OK
        // 道を一つだけ潰すわけなので, むしろ1つを超えて見つけたくない
        if (visited[grid.length - 1][grid[0].length - 1]) {
            return;
        }
        // (0,0) から (i,j) まで少なくとも行けることがわかったので何度も通る必要はない
        if (visited[i][j]) {
            return;
        }
        // grid[i-1][j] == 1 or grid[i][j-1] == 1 の場合のみ次に行ける (深く入って来れる)
        if (grid[i][j] == 1) {
            visited[i][j] = true;
            // いったん通った道を 0 に flip
            // これでなんでもいいから道を１つだけ消す
            // それでも道があるのであれば 1回の flip では断つことはできない
            grid[i][j] = 0;
            if (i < grid.length - 1) {
                updateReachability(grid, i + 1, j, visited);
            }
            if (j < grid[0].length - 1) {
                updateReachability(grid, i, j + 1, visited);
            }
        }
    }
}
