package leetcode.p0566;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        final int m = mat.length;
        final int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        final int[] tmp = new int[m * n];
        int k = 0;
        for (int[] rows : mat) {
            for (int v : rows) {
                tmp[k++] = v;
            }
        }

        final int[][] reMat = new int[r][c];
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reMat[i][j] = tmp[k++];
            }
        }
        return reMat;
    }
}
