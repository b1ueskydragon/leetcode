package leetcode.p0992;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // e.g.,
        // at most 3 = exactly 1 + exactly 2 + exactly 3
        // at most 2 = exactly 1 + exactly 2
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(final int[] nums, final int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        final int n = nums.length;
        int acc = 0;
        int uniqueTypes = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (freq.get(nums[r]) == null || freq.get(nums[r]) == 0) {
                // A very fresh type
                uniqueTypes++;
            }
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            // Since `at most`, this is not valid
            while (uniqueTypes > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    uniqueTypes--;
                }
                l++;
            }
            // The range of [l, r] is valid at this point
            // We need to accumulate the count
            //  == fix the end point and count
            //  == accumulate distance between `l` and `r`
            // e.g.,
            // at most k=2
            // [1, 2, 1, 2, 3]
            //  lr              --> [1](r=0)
            // [1, 2, 1, 2, 3]
            //  l  r            --> [1, 2], [2](r=1)
            // [1, 2, 1, 2, 3]
            //  l     r         --> [1, 2, 1], [2, 1], [1](r=2)
            // [1, 2, 1, 2, 3]
            //  l        r      --> [1, 2, 1, 2], [2, 1, 2], [2](r=3)
            // [1, 2, 1, 2, 3]
            //           l  r   --> [2, 3], [3](r=4)
            acc += (r - l + 1);

            // Anyway, keep moving `r`
        }
        return acc;
    }
}
