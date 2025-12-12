package leetcode.p3417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        final List<Integer> answer = new ArrayList<>();

        final int m = grid.length;
        final int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            // When x is even, x & 1 = 0, otherwise, x & 1 = 1
            for (int j = (i & 1); j < n; j = j + 2) {
                // For odd rows, reverse the column index to traverse right-to-left
                // (n - j if n is even, n - 1 - j if n is odd)
                answer.add(grid[i][(i & 1) == 0 ? j : n - (n & 1) - j]);
            }
        }

        return answer;
    }
}
