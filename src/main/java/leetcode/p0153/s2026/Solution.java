package leetcode.p0153.s2026;

public class Solution implements leetcode.p0153.Solution {
    public int findMin(int[] nums) {
        // Unique elements, sorted in ascending order --> Binary search.
        // A decreasing point is the minimum.
        // rotation e.g.,
        // 1 2 3 4 5 6
        // 6 1 2 3 4 5
        // 5 6 1 2 3 4
        // 4 5 6 1 2 3
        // 3 4 5 6 1 2
        // 2 3 4 5 6 1
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // left-aligned center. Left should not be fixed in the middle.
            final int m = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                // Same as an original order.
                return nums[l];
            }
            if (nums[l] > nums[m]) {
                // There is a decreasing point.
                // Maybe in the left-half.
                r = m;
            } else {
                // The left-half [l,m] is increasing monotonically.
                // Maybe in the right-half.
                // The nums[l] == nums[m] (l == m) case is included.
                l = m + 1;
            }

        }
        return nums[l];
    }
}
