package leetcode.p3689;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        // The window doesn't matter. We can set the window freely.
        int max = 0;
        int min = 1_000_000_000;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // Just be aware to an overflow.
        return (max - min) * 1L * k;
    }
}
