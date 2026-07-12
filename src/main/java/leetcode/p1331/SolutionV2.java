package leetcode.p1331;

import java.util.Arrays;

class SolutionV2 {
    public int[] arrayRankTransform(int[] arr) {
        final int n = arr.length;
        // 0: value, 1: original position, 2: rank of the value
        final int[][] tuples = new int[n][3];
        for (int i = 0; i < n; i++) {
            tuples[i][0] = arr[i];
            tuples[i][1] = i;
        }
        Arrays.sort(tuples, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = Integer.MIN_VALUE;
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (prev != tuples[i][0]) {
                rank++;
            }
            tuples[i][2] = rank;
            prev = tuples[i][0];
        }
        for (int[] tuple : tuples) {
            arr[tuple[1]] = tuple[2];
        }
        return arr;
    }
}
