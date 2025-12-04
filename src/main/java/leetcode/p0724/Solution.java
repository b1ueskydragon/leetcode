package leetcode.p0724;

class Solution {
    public int pivotIndex(int[] nums) {
        final int n = nums.length;
        final int[] leftPrefixSum = new int[n];
        final int[] rightPrefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            leftPrefixSum[i] = (i == 0) ? nums[i] : leftPrefixSum[i - 1] + nums[i];
            rightPrefixSum[n - i - 1] = (i == 0) ? nums[n - 1] : rightPrefixSum[n - i] + nums[n - i - 1];
        }

        // Compute the leftmost pivot index. Traverse left to right.
        // To cover edge cases like [2,1,-1] or [1,-1,2] which pivots are positioned on {0}th index or {n-1}th index,
        // the traverse range extends beyond the left and right edges.
        for (int i = -1; i < n - 1; i++) {
            // The initial value of each pivot sum is zero.
            final int left = (i == -1) ? 0 : leftPrefixSum[i];
            final int right = (i == n - 2) ? 0 : rightPrefixSum[i + 2];
            if (left == right) {
                return i + 1;
            }
        }

        return -1;
    }
}
