package leetcode.p0566;

class Solution {
    // 1D Array xs (flattened array of ys or zs, index: i)
    // 2D original Array ys (index: m, n)
    // 2D reshaped Array zs (index: r, c)
    //
    // xs := [1, 2, 3, 4, 5, 6]
    // ys := [[1,2], [3,4], [5,6]]
    // zs := [[1,2,3], [4,5,6]]
    //
    // To find row indices of 2D Arrays, for example,
    // xs[2] is 3/6 of xs, it can be included in 1/3 (1.5/3, round down) row of xs.
    // And it also can be included in 1/2 row of zs.
    // 3 / 2 == 1, 3 / 3 == 1.
    // i / n == row index of ys, i / c == row index of zs.
    // xs[i] == ys[i / n][_] == zs[i / c][_]
    //
    // About column indices, it is needed to increase them per n step or c step.
    // And each index of ys and zs will be not bigger than n or c.
    // xs[i] == ys[i / n][i % n] == zs[i / c][i % c]
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        final int m = mat.length;
        final int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        final int[][] reMat = new int[r][c];
        // i is an index of 1D (flattened) Array
        for (int i = 0; i < m * n; i++) {
            reMat[i / c][i % c] = mat[i / n][i % n];
        }

        return reMat;
    }
}
