package leetcode.p1685.prefix_suffix_sum;

class Solution {
    // nums sorted in non-decreasing order
    //
    //  res[i] := (nums[i] - nums[0]) + (nums[i] - nums[1]) + ... + (nums[i] - nums[i - 1])
    //          + (nums[i + 1] - nums[i]) + (nums[i + 2] - nums[i]) + ... + (nums[n - 1] - nums[i])
    //
    //          = i * nums[i] - (nums[0] + nums[1] + ... + nums[i - 1])
    //          + (nums[i + 1] + nums[i + 2]] + ... + nums[n - 1]) - (n - i - 1) * nums[i]
    //
    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int n = nums.length;
        final int[] pref = new int[n];
        final int[] suff = new int[n];
        final int[] res = new int[n];
        // Prefix sum to get and accumulate each
        // - (nums[0] + nums[1] + ... + nums[i - 1])
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] - nums[i - 1];
        }
        // Suffix sum to get and accumulate each
        // + (nums[i + 1] + nums[i + 2]] + ... + nums[n - 1])
        // same as
        // + (nums[n - 1] + nums[n - 2] + ... + nums[i + 1])
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + nums[i + 1];
        }
        // Add both and also add remaining
        // i * nums[i] - (n - i - 1) * nums[i]
        for (int i = 0; i < n; i++) {
            res[i] = (2 * i - n + 1) * nums[i] + pref[i] + suff[i];
        }
        return res;
    }
}
