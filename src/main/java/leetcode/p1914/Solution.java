package leetcode.p1914;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;

        // rotateEdge(grid, k, 0, m, n, m, n);
        // rotateEdge(grid, k, 1, m - 1, n - 1, m - 2, n - 2);
        // rotateEdge(grid, k, 2, m - 2, n - 2, m - 4, n - 4);
        // ...
        int start = 0;
        while (start < m - start && start < n - start) {
            rotateEdge(grid, k, start, m - start, n - start, m - 2 * start, n - 2 * start);
            start++;
        }

        return grid;
    }

    private void rotateEdge(int[][] grid, int k, int start, int endM, int endN, int m, int n) {
        final int len = 2 * (m + n - 2);
        final int[] flatten = new int[len];

        // Encode
        int index = 0;
        for (int i = start; i < endN - 1; i++) {
            // System.out.printf("%s ", grid[start][i]);
            flatten[index++] = grid[start][i];
        }
        for (int i = start; i < endM - 1; i++) {
            // System.out.printf("%s ", grid[i][endN - 1]);
            flatten[index++] = grid[i][endN - 1];
        }
        for (int i = endN - 1; i > start; i--) {
            // System.out.printf("%s ", grid[endM - 1][i]);
            flatten[index++] = grid[endM - 1][i];
        }
        for (int i = endM - 1; i > start; i--) {
            // System.out.printf("%s ", grid[i][start]);
            flatten[index++] = grid[i][start];
        }

        // Decode
        for (int i = start; i < endN - 1; i++) {
            grid[start][i] = flatten[k++ % len];
        }
        for (int i = start; i < endM - 1; i++) {
            grid[i][endN - 1] = flatten[k++ % len];
        }
        for (int i = endN - 1; i > start; i--) {
            grid[endM - 1][i] = flatten[k++ % len];
        }
        for (int i = endM - 1; i > start; i--) {
            grid[i][start] = flatten[k++ % len];
        }
    }
}
