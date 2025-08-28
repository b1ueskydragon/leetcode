package leetcode.p3446;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        // n x n
        final int n = grid.length;
        // diagonal
        // (i,j), (i+1,j+1), ...
        //
        // e.g, 3 x 3
        // 0   -> (0, 0), (1, 1), (2, 2)
        // -1  -> (0, 1), (1, 2)
        // 1   -> (1, 0), (2, 1)
        // -2  -> (0, 2)
        // 2   -> (2, 0)
        final Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int key = i - j;
                map.computeIfAbsent(key, k -> (key < 0) ?
                                // ascending order
                                new PriorityQueue<>((a, b) -> a - b) :
                                // descending order
                                new PriorityQueue<>((a, b) -> b - a))
                        .add(grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = map.get(i - j).poll();
            }
        }

        return grid;
    }
}
