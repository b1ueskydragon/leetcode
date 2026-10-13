package leetcode.p3727;

class SolutionV2 {
    // -4 * 10^4 <= nums[i] <= 4 * 10^4
    // score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
    // Sort 後, odd index (arr[1]^2, arr[3]^2, ...) に abs(num) が小さいものを配置.
    public long maxAlternatingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
            max = Math.max(max, nums[i]);
        }
        final int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }
        long right = 0;
        int num = 0;
        int consumed = 0;
        int carryOverFreq = 0;
        long carryOverNum = 0;
        while (consumed < n / 2) {
            if (consumed + freq[num] > n / 2) {
                right += 1L * num * num * (n / 2 - consumed);
                carryOverFreq = consumed + freq[num] - n / 2;
                carryOverNum = num;
                num++;
                break;
            } else {
                right += 1L * num * num * freq[num];
                consumed += freq[num];
                num++;
            }
        }
        long left = 1L * carryOverNum * carryOverNum * carryOverFreq;
        while (num < max + 1) {
            left += 1L * num * num * freq[num];
            num++;
        }
        return left - right;
    }
}
