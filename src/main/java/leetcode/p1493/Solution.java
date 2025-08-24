package leetcode.p1493;

class Solution {
    // You must delete one element
    // nums[i] is either 0 or 1
    //
    // - longest subarray which satisfies a certain condition
    // - delete one element = at most one `0` allowed
    // -> Sliding window
    public int longestSubarray(int[] nums) {
        // 1 <= n <= 10^5
        final int n = nums.length;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        // The number of `0` in the current window
        int zeros = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }
            // Adjust the window until it is valid
            if (zeros > 1) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            // After adjusted the window, now we can compare the length
            // The length may include at most one `0`
            maxLen = Math.max(maxLen, zeros > 0 ? r - l : r - l + 1);
            r++;
        }
        // Handle the edge case where all elements are `1`
        return maxLen == n ? n - 1 : maxLen;
    }
}
