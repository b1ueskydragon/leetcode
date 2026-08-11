package leetcode.p2996;

class Solution {
    // A prefix nums[0..i] is sequential. Must include nums[0].
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                break;
            }
            prefixSum += nums[i];
        }
        // The possible max sequential sum.
        final int max = (1 + 50) * 50 / 2;
        final boolean[] exists = new boolean[max + 1];
        for (int num : nums) {
            exists[num] = true;
        }
        for (int num = prefixSum; num <= max; num++) {
            if (!exists[num]) {
                return num;
            }
        }
        return prefixSum;
    }
}
