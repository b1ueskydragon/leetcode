package leetcode.p2348;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // 1 <= n <= 10^5
        final int n = nums.length;
        // -10^9 <= nums[i] <= 10^9
        long count = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                res += sum(count);
                count = 0; // reset
            }
        }
        if (count > 0) {
            res += sum(count);
        }
        return res;
    }

    // Get all CONTIGUOUS sequences
    // e.g.,
    // (0, 0, 0, 0, 0)
    // (0): 5
    // (0, 0): 4
    // (0, 0, 0): 3
    // (0, 0, 0, 0): 2
    // (0, 0, 0, 0, 0): 1
    private static long sum(long n) {
        return (1 + n) * n / 2;
    }
}
