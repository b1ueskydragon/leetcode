package leetcode.p3379;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        final int n = nums.length;
        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            // Normalize to non-negative. Unify all jumps to the right.
            if (k < 0) {
                k = n - (Math.abs(k) % n);
            }
            result[i] = nums[(i + k) % n];
        }
        return result;
    }
}
