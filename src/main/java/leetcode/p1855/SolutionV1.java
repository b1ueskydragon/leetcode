package leetcode.p1855;

class SolutionV1 implements Solution {

    public int maxDistance(int[] nums1, int[] nums2) {
        int best = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = binarySearch(nums2, i, nums1[i]);
            if (i <= j) {
                best = Math.max(best, j - i);
            }
            // System.out.printf("%s %s %s %n", i, nums1[i], j);
        }

        return best;
    }

    // nums: sorted non-increasing
    // Find an index of the smallest number where is larger or equal to the target.
    private int binarySearch(int[] nums, int l, int target) {
        // l が行きすぎることになるため return l - 1, r を exclusive にすることで取りこぼしがないようにする.
        int r = nums.length;
        while (l < r) {
            // left-aligned center, l must not be pinned in the center.
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                // Can be an answer, but try more.
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }

}
