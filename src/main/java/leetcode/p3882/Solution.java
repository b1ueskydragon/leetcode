package leetcode.p3882;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
class Solution {
    // Minimum possible XOR (0,0) -> (m-1, n-1).
    // Move either right or down, including the start and end cells.
    // m*n <= 1000
    // 0 <= grid value < (1 << 10)
    // 0 <= any XOR < (1 << 10)
    // A smaller XOR so far does not guarantee a smaller XOR after the next cell.
    // At most 1000 * 1024 ≈ 10^6 states, which is feasible.
    public int minCost(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final Set[][] dp = new Set[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == null) {
                    dp[i][j] = new HashSet<Integer>();
                }
                final int v = grid[i][j];
                if (i == 0 && j == 0) {
                    dp[i][j].add(v);
                    continue;
                }
                if (j != 0) {
                    for (var xor : dp[i][j - 1]) {
                        dp[i][j].add((int) xor ^ v);
                    }
                }
                if (i != 0) {
                    for (var xor : dp[i - 1][j]) {
                        dp[i][j].add((int) xor ^ v);
                    }
                }
            }
        }
        int minXor = Integer.MAX_VALUE;
        for (var xor : dp[m - 1][n - 1]) {
            minXor = Math.min(minXor, (int) xor);
        }
        return minXor;
    }
}
