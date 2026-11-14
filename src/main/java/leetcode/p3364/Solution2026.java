package leetcode.p3364;

import java.util.List;

class Solution2026 {
    // 1 <= l <= r <= n
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        final int n = nums.size();
        int minPosSum = Integer.MAX_VALUE;
        final int[] prefixSum = new int[n + 1]; // prefixSum[0] = 0, sentinel
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + l - 1; j < i + r; j++) {
                final int cutoff = j >= n ? n - 1 : j;
                if (cutoff - i + 1 < l) {
                    continue;
                }
                final int rangeSum = prefixSum[cutoff + 1] - prefixSum[i];
                minPosSum = rangeSum <= 0 ? minPosSum : Math.min(minPosSum, rangeSum);
            }
        }
        return minPosSum == Integer.MAX_VALUE ? -1 : minPosSum;
    }
}
