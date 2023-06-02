package leetcode.p0485.distance_of_zero;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0, fast = 0;
        int distance = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                fast++;
                continue;
            }
            distance = Math.max(distance, fast - slow);
            fast++;
            // to omit -1 from fast-slow-1, set slow on 1 next to 0.
            slow = fast;
        }
        return Math.max(distance, fast - slow);
    }
}
