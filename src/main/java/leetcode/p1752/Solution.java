package leetcode.p1752;

class Solution {
    public boolean check(int[] nums) {
        final int n = nums.length;
        int i = 0;
        // Find a boundary of the maximum value and minimum value.
        while (i < n - 1) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
            i++;
        }
        final int m = n + i;
        i++;
        // Keep searching from the minimum value's index.
        // At most n times from the start point is fine.
        while (i < m) {
            if (nums[i % n] > nums[(i + 1) % n]) {
                return false;
            }
            i++;
        }

        return true;
    }
}
