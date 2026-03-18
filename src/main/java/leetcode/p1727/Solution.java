package leetcode.p1727;

import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        // e.g.,
        //
        // given:
        // 0  0  1
        // 1  1  1
        // 1  0  1
        //
        // after accumulate consecutive heights:
        // 0  0  1
        // 1  1  2
        // 2  0  3  <-- once 0 appears, reset the height.
        int best = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i > 0) && (matrix[i][j] != 0) ?
                        matrix[i][j] + matrix[i - 1][j] : matrix[i][j];
            }
            // To maintain the entire order, instead of sorting every row at once,
            // we partially sort -> attempt only the row we are currently viewing.
            int[] currRow = new int[n];
            System.arraycopy(matrix[i], 0, currRow, 0, n);
            Arrays.sort(currRow);
            // e.g.,
            //
            // the row, values are accumulated height:
            // 0  1  2  3 [ 3 ]
            //              ^----- curr
            // one of the possible restored matrixs should be:
            // 0  0  0  1 [ 1 ]
            // 0  0  1  1 [ 1 ]
            // 0  1  1  1 [ 1 ]
            //              ^----- area (height * width) = 3 * 1
            //
            // another row:
            // 0  1  [ 2  3  3 ]
            //         ^----- curr
            // restored:
            // 0  0   0  1  1
            // 0  0 [ 1  1  1 ]
            // 0  1 [ 1  1  1 ]
            //        ^----------- area = 2 * 3
            int maxSize = currRow[n - 1] * 1;
            for (int r = n - 2; r >= 0; r--) {
                if (currRow[r] == 0) {
                    // Already sorted, next is always 0, cannot build rectangles.
                    break;
                }
                int width = n - r;
                // Already sorted, next is always less than equal to current.
                int height = currRow[r];
                maxSize = Math.max(maxSize, width * height);
            }
            best = Math.max(best, maxSize);
        }
        return best;
    }
}
