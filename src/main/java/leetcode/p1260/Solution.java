package leetcode.p1260;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //     1 2 3 / 4 5 6 / 7 8 9
        // --> 9 1 2 / 3 4 5 / 6 7 8
        final int m = grid.length;
        final int n = grid[0].length;
        k = k % (m * n);
        final int[] flatten = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flatten[index++] = grid[i][j];
            }
        }
        final List<List<Integer>> shifted = new ArrayList<>();
        index = (m * n) - k;
        for (int i = 0; i < m; i++) {
            shifted.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                shifted.get(i).add(flatten[index % (m * n)]);
                index++;
            }
        }
        return shifted;
    }
}
