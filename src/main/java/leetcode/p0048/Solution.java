package leetcode.p0048;

class Solution {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length); // n x n
    }

    private void rotate(int[][] matrix, int start, int n) {
        if (n == 0 || n == 1) {
            // Do nothing.
            return;
        }

        final int end = start + n - 1;
        for (int i = start; i < end; i++) {
            final int offset = i - start;

            int v1 = matrix[start][i];
            int v2 = matrix[i][end];
            int v3 = matrix[end][end - offset];
            int v4 = matrix[end - offset][start];

            // System.out.printf("%s %s %s %s %n", v1, v2, v3, v4);

            matrix[start][i] = v4;
            matrix[i][end] = v1;
            matrix[end][end - offset] = v2;
            matrix[end - offset][start] = v3;
        }

        rotate(matrix, start + 1, n - 2);
    }
}
