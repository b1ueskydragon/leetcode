package leetcode.p2033;

import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        // Find a median value.
        // Find an operation count == 0 value first (the value which no needs to modify) and that would be a median value.
        // To equalize all values with minimum operations, pick the median value.
        // In other words, to make a Σ|x_i - v| as the minimum, v should be the median value of [x_1, ..., x_n].
        // Note: Not a mean, using median.

        final int m = grid.length;
        final int n = grid[0].length;
        final int[] nums = new int[m * n]; // flatten to an array
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[idx++] = grid[i][j];
            }
        }
        Arrays.sort(nums); // sort to find a median

        int left = 0;
        int right = m * n - 1;
        int mid = left + (right - left) / 2;
        int median = nums[mid];
        int opCount = 0;
        for (int num : nums) {
            final int diff = Math.abs(median - num);
            if (diff % x != 0) {
                return -1;
            }
            opCount += (diff / x);
        }
        return opCount;
    }
}
