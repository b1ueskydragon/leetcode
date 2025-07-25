package leetcode.p1695;

import java.util.HashSet;

class Solution {
    // Get max consecutive and unique sum
    // Should be adjacent ... Sliding window
    // Unique ... Hash Table
    // `nums` only contains positive integers
    public int maximumUniqueSubarray(int[] nums) {
        final var seen = new HashSet<Integer>();
        int l = 0;
        int sum = 0;
        int maxSum = 0;
        for (int r = 0; r < nums.length; r++) {
            if (!seen.contains(nums[r])) {
                seen.add(nums[r]);
                sum += nums[r];
                maxSum = Math.max(sum, maxSum);
                continue;
            }
            // While a duplicate exists at nums[r], we cannot expand the window to the right
            // Instead, move `l` (shrink the window) to remove duplicates
            while (seen.contains(nums[r])) {
                seen.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            // After removing duplicates, add nums[r] back to the window
            // Since `r` has not moved yet at this point
            seen.add(nums[r]);
            // We have not added yet, so add it
            sum += nums[r];
        }
        return maxSum;
    }
}
