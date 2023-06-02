package leetcode.p0081;

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int prev = -10001;
        int s = 0;
        for (int i = 0; i < n; i++) {
            final int v = nums[i];
            if (v == target) return true;
            if (prev > v) {
                s = i;
                break;
            }
        }

        final boolean isZeroStart = nums[s] > target;
        int l = isZeroStart ? 0 : s;
        int r = isZeroStart ? s - 1 : n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }
}
