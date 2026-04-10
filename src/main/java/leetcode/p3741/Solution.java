package leetcode.p3741;

import java.util.Arrays;

class Solution {
    // nums[i] == nums[j] == nums[k],
    // abs(i - j) + abs(j - k) + abs(k - i)
    // i < j < k , (k - i) * 2. No matter where the middle j is.
    // Find the minimum.
    public int minimumDistance(int[] nums) {
        // Constraints:
        // 1 <= n <= 100000
        // 1 <= nums[i] <= n
        final int n = nums.length;
        // e.g.,
        // [1,2,1,1,1,2,1,1,1,2,2,1]
        // n: (i,j,k)
        // 1: (0,2,3), (2,3,4), (3,4,6), (4,6,7), (6,7,11)
        // 2: (1,5,9), (5,9,10)
        final int[][] map = new int[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            // int is primitive, using Arrays#fill is OK.
            Arrays.fill(map[i], -1);
        }

        int best = 200000; // Unreachable due to the constraints.

        for (int i = 0; i < n; i++) {
            int[] pos = map[nums[i]];
            if (pos[0] == -1) {
                pos[0] = i;
            } else if (pos[1] == -1) {
                pos[1] = i;
            } else if (pos[2] == -1) {
                pos[2] = i;
                // Chance to compare.
                best = Math.min(best, (pos[2] - pos[0]) * 2);
            } else {
                // {i,j,k} is already filled.
                // Shift the first and second indices to left, then fill a new index.
                pos[0] = pos[1];
                pos[1] = pos[2];
                pos[2] = i;
                // Chance to compare.
                best = Math.min(best, (pos[2] - pos[0]) * 2);
            }
        }

        return best == 200000 ? -1 : best;
    }
}
