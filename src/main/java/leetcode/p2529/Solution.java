package leetcode.p2529;

class Solution {
    // Constraints: non-decreasing order, O(log(n)) time complexity
    public int maximumCount(int[] nums) {
        final int n = nums.length;
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return n;
        }
        final int l = findTheLargestNeg(nums);
        final int r = findTheSmallestPos(nums);
        return Math.max(l + 1, n - r);
    }

    private int findTheLargestNeg(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // index
        return l - 1;
    }

    private int findTheSmallestPos(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // index
        return r + 1;
    }
}
