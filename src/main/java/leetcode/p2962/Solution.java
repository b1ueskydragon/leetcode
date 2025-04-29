package leetcode.p2962;

class Solution {
    // At least k
    // Contiguous sequence
    public long countSubarrays(int[] nums, int k) {
        // Find a max (<= 10^6)
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        final int n = nums.length;
        int l = 0;
        long cnt = 0;
        long res = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == maxNum) {
                cnt++;
            }
            while (cnt == k) {
                // Since the condition is `at least k`, after meeting k times,
                // every extension to the right will also satisfy the condition
                // So we can count `n-r` subarrays at once
                // e.g.,
                // k=2, nums=[1,3,2,3,3],
                // When
                // [1,3,2,3,3]
                //  l     r      is valid
                // [1,3,2,3,3]
                //  l       r    is also valid
                res += (n - r);
                if (nums[l] == maxNum) {
                    cnt--;
                }
                l++;
            }
            // Valid window at this point, keep moving `r`
        }
        return res;
    }
}
