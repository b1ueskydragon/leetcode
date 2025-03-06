package leetcode.p2965;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int n = grid.length;
        // Constraints: n*n grid, max 50x50 grid
        // 1 <= number <= n*n
        // Array is enough
        final int[] slot = new int[n * n + 1];
        slot[0] = 1; // sentinel
        // We need to retrieve all from (0,0) to (n-1,n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int number = grid[i][j];
                slot[number]++;
            }
        }

        final int[] pair = new int[2];
        for (int i = 0; i < slot.length; i++) {
            if (slot[i] > 1) {
                pair[0] = i;
                continue;
            }
            if (slot[i] == 0) {
                pair[1] = i;
            }
        }
        return pair;
    }
}
