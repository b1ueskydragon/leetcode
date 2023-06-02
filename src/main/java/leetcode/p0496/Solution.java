package leetcode.p0496;

import java.util.HashMap;
import java.util.Map;

// Beats 95.79% time
class Solution {
    // constraints:
    // - all integers in nums1 and nums2 are unique
    // - all the integers of nums1 also appear in nums2.
    // - 0 <= num <= 10_000
    // - 1 <= nums length <= 1000
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int n = nums2.length;
        final int[] nextGreaters = new int[n];
        final Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nextGreaters[i] = -1;
            indices.put(nums2[i], i);
        }
        for (int i = 0; i < n; i++) {
            final int num = nums2[i];
            for (int j = i + 1; j < n; j++) {
                if (num < nums2[j]) {
                    nextGreaters[i] = nums2[j];
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaters[indices.get(nums1[i])];
        }
        return nums1;
    }
}
