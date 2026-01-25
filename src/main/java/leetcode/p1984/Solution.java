package leetcode.p1984;

import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = 100_000;
        int i = 0;
        while (i + k - 1 < nums.length) {
            diff = Math.min(diff, nums[i + k - 1] - nums[i]);
            i++;
        }
        return diff;
    }
}
