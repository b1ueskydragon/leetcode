package leetcode.p1893;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // Check boundaries only.
        // -1 is opened, 1 is closed.
        // Allow null to describe `not covered`.
        final Integer[] nums = new Integer[51];
        for (int[] range : ranges) {
            // If the slot is already opened|closed, just accumulate to the previous flag.
            nums[range[0]] = (nums[range[0]] == null) ? -1 : nums[range[0]] - 1;
            nums[range[1]] = (nums[range[1]] == null) ? 1 : nums[range[1]] + 1;
        }

        // 0 is finally closed.
        // Overlapped range will be accumulated as -2, -3, ... .
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == null) {
                continue;
            }
            if (nums[i] == null && nums[i - 1] != 0) {
                nums[i] = nums[i - 1];
                continue;
            }
            if (nums[i] != null) {
                nums[i] += nums[i - 1];
            }
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == null) {
                return false;
            }
        }
        return true;
    }
}
