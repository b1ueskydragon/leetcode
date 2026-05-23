package leetcode.p0033;

class Solution2026 implements Solution {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // left-aligned center.
            int m = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                // Not rotated.
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                // Rotated.
                if (nums[l] <= nums[m]) {
                    // Since the left-aligned center, consider l == m case in here.
                    // At least [l, m] is sorted.
                    if (target > nums[m] || target < nums[l]) {
                        // Out of range. Move to the right half.
                        // `l` always not be fixed in the middle, so do not use <= comparison.
                        l = m + 1;
                    } else {
                        r = m;
                    }
                } else {
                    // At least [m, r] is sorted.
                    if (target <= nums[m] || target > nums[r]) {
                        // Out of range. Move to the left half.
                        // We consider `r` is a candidate, so use <= comparison.
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
            }
        }
        return nums[r] == target ? r : -1;
    }

}
