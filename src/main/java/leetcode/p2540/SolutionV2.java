package leetcode.p2540;

class SolutionV2 implements Solution {

    public int getCommon(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        // O(m * log N) or O(n * log M)
        // Apply log for the bigger one.
        if (m > n) {
            return getCommon(nums2, nums1);
        }
        for (int num : nums1) {
            int i = binarySearch(nums2, num);
            if (i == -1 || nums2[i] != num) {
                continue;
            }
            return num;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            // left-aligned center. don't fix l in the middle.
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else {
                // l can be a candidate.
                l = m + 1;
            }
        }
        return l - 1; // l may proceed to much.
    }

}
