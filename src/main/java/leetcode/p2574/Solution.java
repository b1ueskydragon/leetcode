package leetcode.p2574;

class Solution {
    // 1000 * 100000 < Integer.MAX_VALUE
    public int[] leftRightDifference(int[] nums) {
        final int n = nums.length;
        final int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i - 1];
        }
        int prefixSum = ans[n - 1];
        ans[n - 1] = prefixSum;
        int suffixSum = 0;
        for (int i = n - 2; i >= 0; i--) {
            prefixSum = ans[i];
            suffixSum += nums[i + 1];
            ans[i] = Math.abs(prefixSum - suffixSum);
        }
        return ans;
    }
}
