package leetcode.p0198;

class Solution {
    // Constraints: Cannot pick adjacent houses.
    public int rob(int[] nums) {
        final int n = nums.length;
        final int[] soFarStatus = new int[n];
        for (int i = 0; i < n; i++) {
            // The version of including current value.
            final int includeCurr = (i > 1) ? nums[i] + soFarStatus[i - 2] : nums[i];
            // The version of excluding current value and take over previous sum.
            final int excludeCurr = (i > 0) ? soFarStatus[i - 1] : nums[i];
            soFarStatus[i] = Math.max(includeCurr, excludeCurr);
        }
        return soFarStatus[n - 1];
    }
}
