package leetcode.p2022;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        final int N = original.length;
        if (N != m * n) {
            return new int[0][0];
        }
        final int[][] res = new int[m][n];
        for (int i = 0; i < N; i++) {
            res[i / n][i % n] = original[i];
        }
        return res;
    }
}
