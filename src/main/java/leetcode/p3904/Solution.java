package leetcode.p3904;

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        final int n = nums.length;
        final int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }
        int prefixMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            final int instability = prefixMax - suffixMin[i];
            if (instability <= k) {
                // The smallest stable index.
                return i;
            }
        }
        return -1;
    }
}
