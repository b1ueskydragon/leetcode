package leetcode.p0045;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0; // The farthest place that we can jump from the current place
        int pin = 0; // Pin the farthest place (limit) from the current place
        final int n = nums.length;
        // n-1: We need to stop jumping when we reached to the last index
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == pin) {
                jumps++;
                pin = farthest;
            }
        }
        return jumps;
    }
}
