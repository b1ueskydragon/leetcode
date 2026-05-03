package leetcode.p0396;

class Solution {
    // Constraint:
    // The answer fits in a 32-bit integer.
    // -100 <= nums[i] <= 100, 100000 * 100 * 100 < Integer.MAX_VALUE.
    // 1 <= n <= 10^5, O(n^2) will be slow so avoid brute-force.
    public int maxRotateFunction(int[] nums) {

        // e.g.,
        //
        // nums = [4, 3, 2, 6]
        // F(0)    0  1  2  3  =  0 + 3 + 4 + 18 = 25 (= 26 - (3 * 4) + 3 + 2 + 6)
        // F(1)    1  2  3  0  =  4 + 6 + 6 + 0  = 25  + 4 + 3 + 2 - (6 * 3) = 16
        // F(2)    2  3  0  1  =  8 + 9 + 0 + 6  = 16  + 4 + 3 - (2 * 3) + 6 = 23
        // F(1)    3  0  1  2  = 12 + 0 + 2 + 12 = 23  + 4 - (3 * 3) + 2 + 6 = 26

        final int n = nums.length;
        int acc = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            acc += i * nums[i];
            sum += nums[i];
        }
        int max = acc;

        // acc_0 = an initial result
        // acc_1 = acc_0 + nums[0] + nums[1] + ... + nums[n - 2] - (nums[n - 1] * (n - 1))
        // acc_2 = acc_1 + nums[1] + nums[2] + ... + nums[n - 3] - (nums[n - 2] * (n - 1))
        // ...
        // Do not compute the sum repeatedly.
        // Do it prefix-sum-ish in O(n). subtract a missing-num from sum(nums).

        for (int i = 0; i < n; i++) {
            // 欠番: n-i-1 index.
            acc += (sum - nums[n - i - 1]) - (nums[n - i - 1] * (n - 1));
            max = Math.max(acc, max);
        }
        return max;
    }
}
