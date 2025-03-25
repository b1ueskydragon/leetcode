package leetcode.p0213;

class Solution {
    // Constraints:
    // - Arranged in a circle
    // - Cannot pick adjacent values
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // [0...n-2] VS [1...n-1]
        //
        // Sine the first and last house are adjacent in a circle,
        // we cannot rob both nums[0] and nums[n - 1] together.
        // Therefore, we split the problem into two exclusive cases:
        // (1) Rob houses from index 0 to n-2 (exclude the last)
        // (2) Rob houses from index 1 to n-1 (exclude the first)
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // Both start and end are inclusive indices
    private int robRange(int[] nums, int start, int end) {
        final int n = end - start + 1;
        final int[] soFarMax = new int[n + 1];
        for (int i = start; i <= end; i++) {
            final int currIncl = (i > 1) ? nums[i] + soFarMax[i - 2] : nums[i];
            final int currExcl = (i > 0) ? soFarMax[i - 1] : nums[i];
            soFarMax[i] = Math.max(currIncl, currExcl);
        }
        final int last = (soFarMax[n] == 0) ? n - 1 : n;
        return soFarMax[last];
    }
}
