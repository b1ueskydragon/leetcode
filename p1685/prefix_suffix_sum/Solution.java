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
    //          it can be replaced to prefix sum
    //
    //          = i * nums[i] - prefixSum[i - 1]
    //          + prefixSum[n - 1] - prefixSum[i] - (n - i - 1) * nums[i]
    //
    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int n = nums.length;
        final int[] prefixSum = new int[n + 1]; // sentinel
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = i * nums[i] - prefixSum[i]
                    + prefixSum[n] - prefixSum[i + 1] - (n - i - 1) * nums[i];
        }
        return res;
    }
}
