package leetcode.p3364;

import java.util.List;

class Solution {
    // Subarray is contiguous
    // Tiny size (1 <= nums.length <= 100); O(N * k) time is acceptable when k is (r − l + 1)
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        final int n = nums.size();
        final int[] prefixSum = new int[n];
        prefixSum[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i);
        }

        int nonNegativeMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            final int left = i + l - 1;
            final int right = i + r - 1;

            int j = left;
            while (j < n && j <= right) {
                final int cand = (i > 0) ? prefixSum[j] - prefixSum[i - 1] : prefixSum[j];

                nonNegativeMin = (cand <= 0) ? nonNegativeMin : Math.min(cand, nonNegativeMin);
                j++;
            }
        }
        return (nonNegativeMin == Integer.MAX_VALUE) ? -1 : nonNegativeMin;
    }
}
