package leetcode.p3742;

// BFS は使えない. visited が使えないので (同じ cell でも cost, score が違うと別状態) TLE になる.
// 各 cell, 複数の (cost, score) を保つ必要がある -> List[][] DP
// ただし k は小さく, 同じ cost なら最大 score だけ残せばよい. List で全部保持する必要はない.
// -> cost を key とする int[][][] DP におさまる.
class Solution {
    // Constraint: (0, 0) to (m-1, n-1),
    // move down and right are allowed.
    // k <= 1000
    public int maxPathScore(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        // max 比較で必ず選ばれない (足し算しても大きな負数のままでいられる) 適当な大きさの invalid 値.
        final int NaN = Integer.MIN_VALUE;
        // [i][j][cost] = max score
        final int[][][] dp = new int[m][n][1001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost < 1001; cost++) {
                    dp[i][j][cost] = NaN;
                }
            }
        }
        dp[0][0][0] = 0;

        // Simply accumulating.
        // first row/column must accumulate previous results.
        int costSoFar = 0;
        for (int j = 1; j < n; j++) {
            final int v = grid[0][j];
            if (getCost(v) + costSoFar > k) {
                break;
            }
            dp[0][j][getCost(v) + costSoFar] = v + dp[0][j - 1][costSoFar];
            costSoFar += getCost(v);
        }
        costSoFar = 0;
        for (int i = 1; i < m; i++) {
            final int v = grid[i][0];
            if (getCost(v) + costSoFar > k) {
                break;
            }
            dp[i][0][getCost(v) + costSoFar] = v + dp[i - 1][0][costSoFar];
            costSoFar += getCost(v);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                final int v = grid[i][j]; // v itself is a score
                for (int cost = 0; getCost(v) + cost <= k; cost++) {
                    dp[i][j][getCost(v) + cost] = Math.max(dp[i][j][getCost(v) + cost], v + dp[i][j - 1][cost]);
                    dp[i][j][getCost(v) + cost] = Math.max(dp[i][j][getCost(v) + cost], v + dp[i - 1][j][cost]);

                }
            }
        }

        int best = -1;
        for (int cost = 0; cost <= k; cost++) {
            // System.out.printf("%s %s %n", cost, dp[m - 1][n - 1][cost]);
            best = Math.max(best, dp[m - 1][n - 1][cost]);
        }
        return best;
    }

    private int getCost(int v) {
        return v == 0 ? 0 : 1;
    }
}
