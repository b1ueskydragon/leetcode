package leetcode.p3727;

import java.util.Arrays;

class SolutionV1 {
    // score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
    // -4 * 10^4 <= nums[i] <= 4 * 10^4
    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        long right = 0;
        // odd index (arr[1]^2, arr[3]^2, ...) に abs(num) が小さいものを配置.
        for (int i = 0; i < n / 2; i++) {
            right += (nums[i] * 1L);
        }
        long left = 0;
        for (int i = n / 2; i < n; i++) {
            left += (nums[i] * 1L);
        }
        return left - right;
    }
}
