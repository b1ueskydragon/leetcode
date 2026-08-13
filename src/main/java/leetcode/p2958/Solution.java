package leetcode.p2958;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // At most k -> 0 frequency is also allowed.
    public int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        final int n = nums.length;
        int l = 0;
        int r = 0;
        int maxSubLen = 0;
        // Compare the maximum distance from l, l+1, ...
        // But r does not need to move back
        // -> Sliding Window
        while (l <= r && r < n) {
            freq.putIfAbsent(nums[r], 0);
            if (freq.get(nums[r]) < k) {
                freq.put(nums[r], freq.get(nums[r]) + 1);
                maxSubLen = Math.max(maxSubLen, r - l + 1);
                r++;
            } else {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                l++;
            }
        }
        return maxSubLen;
    }
}
