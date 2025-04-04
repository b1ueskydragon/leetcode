package leetcode.p2874;

class Solution {
    // Constraints: i < j < k
    // Fix `j` (the pivot) first
    // 1 <= j <= n-2
    public long maximumTripletValue(int[] nums) {
        final int n = nums.length;

        // (1) Precompute

        // leftMax[j]: the maximum value in nums[0..j-1] (i < j)
        // Computing a prefix maximum with a top-down scan
        // (The leftmost value is fixed at the beginning)
        final int[] leftMax = new int[n];
        for (int j = 1; j < n - 1; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], nums[j - 1]);
        }

        // rightMax[j]: the maximum value in nums[j+1..n-1] (k > j)
        // Computing a suffix maximum with a bottom-up scan
        // (The rightmost value is fixed at the beginning)
        final int[] rightMax = new int[n];
        for (int j = n - 2; j > 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], nums[j + 1]);
        }

        // (2) Find the maximum result based on given formula

        // Note: Cast to long type to prevent overflow
        long maxRes = 0;
        for (int j = 1; j < n - 1; j++) {
            maxRes = Math.max(maxRes, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }

        return maxRes;
    }
}
