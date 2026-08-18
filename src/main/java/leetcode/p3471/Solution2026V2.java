package leetcode.p3471;

class Solution2026V2 {
    public int largestInteger(int[] nums, int k) {
        final int n = nums.length;
        final int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        if (k == n) {
            int ans = -1;
            for (int num = 0; num < 51; num++) {
                if (freq[num] > 0) {
                    ans = Math.max(num, ans);
                }
            }
            return ans;
        }
        if (k == 1) {
            int ans = -1;
            for (int num : nums) {
                if (freq[num] == 1) {
                    ans = Math.max(num, ans);
                }
            }
            return ans;
        }
        // No overlapped section: Head or last.
        // However some head or last may duplicate in the nums.
        if (freq[nums[0]] > 1 && freq[nums[n - 1]] > 1) {
            return -1;
        } else if (freq[nums[0]] > 1) {
            return nums[n - 1];
        } else if (freq[nums[n - 1]] > 1) {
            return nums[0];
        } else {
            return Math.max(nums[0], nums[n - 1]);
        }
    }
}
