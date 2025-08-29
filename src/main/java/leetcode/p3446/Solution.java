package leetcode.p3446;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    static class V2 {
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
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!(i == 0 || j == 0)) {
                        // Cannot set as a start point
                        continue;
                    }

                    // Collect and sort
                    final int offset = i - j;
                    final int size = n - Math.abs(offset);
                    final int[] tmp = new int[size];
                    // Using new pointers to not proceed i, j themselves
                    int x = i;
                    int y = j;
                    for (int k = 0; k < size; k++) {
                        tmp[k] = grid[x++][y++];
                    }

                    Arrays.sort(tmp);

                    // Restore
                    // Using new pointers to not proceed i, j themselves
                    x = i;
                    y = j;
                    if (offset < 0) {
                        // Ascending order
                        for (int k = 0; k < size; k++) {
                            grid[x++][y++] = tmp[k];
                        }
                    } else {
                        // Descending order
                        for (int k = size - 1; k >= 0; k--) {
                            grid[x++][y++] = tmp[k];
                        }
                    }
                }
            }

            return grid;
        }
    }

    static class V1 {

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

}
