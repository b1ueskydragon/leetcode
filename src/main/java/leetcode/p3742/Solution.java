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
        final int NaN = -2000; // 適当な大きさの invalid 値.
        // [i][j][cost] = max score
        final int[][][] dp = new int[m][n][1001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost < 1001; cost++) {
                    dp[i][j][cost] = NaN;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int v = grid[i][j];
                if (i == 0 && j == 0) {
                    dp[i][j][0] = 0;
                } else if (i == 0) {
                    for (int cost = 0; getCost(v) + cost <= k; cost++) {
                        if (dp[i][j - 1][cost] == NaN) {
                            continue;
                        }
                        dp[i][j][getCost(v) + cost] = v + dp[i][j - 1][cost];
                    }
                } else if (j == 0) {
                    for (int cost = 0; getCost(v) + cost <= k; cost++) {
                        if (dp[i - 1][j][cost] == NaN) {
                            continue;
                        }
                        dp[i][j][getCost(v) + cost] = v + dp[i - 1][j][cost];
                    }
                } else {
                    final int[] lefts = dp[i][j - 1];
                    final int[] ups = dp[i - 1][j];
                    for (int cost = 0; getCost(v) + cost <= k; cost++) {
                        if (dp[i][j - 1][cost] == NaN) {
                            continue;
                        }
                        dp[i][j][getCost(v) + cost] =
                                Math.max(dp[i][j][getCost(v) + cost], v + dp[i][j - 1][cost]);
                    }

                    for (int cost = 0; getCost(v) + cost <= k; cost++) {
                        if (dp[i - 1][j][cost] == NaN) {
                            continue;
                        }
                        dp[i][j][getCost(v) + cost] =
                                Math.max(dp[i][j][getCost(v) + cost], v + dp[i - 1][j][cost]);
                    }
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
