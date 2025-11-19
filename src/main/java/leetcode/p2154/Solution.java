package leetcode.p2154;

class Solution {
    // 1 <= nums.length <= 1000
    // 1 <= nums[i], original <= 1000
    public int findFinalValue(int[] nums, int original) {
        final boolean[] exists = new boolean[1001];
        for (int num : nums) {
            exists[num] = true;
        }
        while (original <= 1000) {
            if (!exists[original]) {
                return original;
            }
            original <<= 1;
        }
        return original;
    }
}
