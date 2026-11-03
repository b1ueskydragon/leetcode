package leetcode.p3736;

class Solution {
    // Only an increase is allowed.
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int diffs = 0;
        for (int num : nums) {
            diffs += max - num;
        }
        return diffs;
    }
}
