package leetcode.p2906;

class Solution {
    // Division は modulo 結合法則が成立しないので Division は使わない.
    // 前後の multiplication を利用する.
    // e.g.,
    // 1D array
    // [4, 2, 3]
    // prefix product except itself
    // [_, 4, 8]
    // suffix product except itself
    // [6, 3, _]
    // then combine
    // [6, 12, 8]
    public int[][] constructProductMatrix(int[][] grid) {
        // 問題が n*m なので従っているだけ.
        final int n = grid.length;
        final int m = grid[0].length;

        // 上から下へ, 右方向
        // e.g.,
        //  4  2  3
        //  3 [1] 2  前方 product except (1,1) = prefix[1][0] * grid[1][0]
        //  2  4  1
        final int[][] prefix = new int[n][m];

        // 下から上へ, 左方向
        // e.g.,
        //  4  2  3
        //  3 [1] 2  後方 product except (1,1) = suffix[1][2] * grid[1][2]
        //  2  4  1
        final int[][] suffix = new int[n][m];

        // prefix なので → 方向のみ考える.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    prefix[i][j] = 1;
                } else if (i == 0) {
                    // prefix[i][j] = prefix[i][j - 1] * grid[i][j - 1];
                    prefix[i][j] = multiply(prefix[i][j - 1], grid[i][j - 1]);
                } else if (j == 0) {
                    // prefix[i][j] = prefix[i - 1][m - 1] * grid[i - 1][m - 1];
                    prefix[i][j] = multiply(prefix[i - 1][m - 1], grid[i - 1][m - 1]);
                } else {
                    // prefix[i][j] = prefix[i][j - 1] * grid[i][j - 1];
                    prefix[i][j] = multiply(prefix[i][j - 1], grid[i][j - 1]);
                }
            }
        }

        // sufix なので ← 方向のみ考える.
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    suffix[i][j] = 1;
                } else if (i == n - 1) {
                    // suffix[i][j] = suffix[i][j + 1] * grid[i][j + 1];
                    suffix[i][j] = multiply(suffix[i][j + 1], grid[i][j + 1]);
                } else if (j == m - 1) {
                    // suffix[i][j] = suffix[i + 1][0] * grid[i + 1][0];
                    suffix[i][j] = multiply(suffix[i + 1][0], grid[i + 1][0]);
                } else {
                    // suffix[i][j] = suffix[i][j + 1] * grid[i][j + 1];
                    suffix[i][j] = multiply(suffix[i][j + 1], grid[i][j + 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = multiply(prefix[i][j], suffix[i][j]);
            }
        }

        return prefix;
    }

    // mod = 12345,
    // 12344 * 12344 < Integer.MAX_VALUE
    private int multiply(int x, int y) {
        final int mod = 12345;
        return ((x % mod) * (y % mod)) % mod;
    }
}
