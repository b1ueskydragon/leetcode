package leetcode.p0088.s202406;

class Solution {
    // Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    // nums1 has a length of m + n, where the first m elements denote the elements that should be merged
    // and the last n elements are set to 0 and should be ignored.
    // nums2 has a length of n.
    // in-place, O(m + n) time.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // search and fill number in from the last
        int p = m - 1;
        int q = n - 1;
        // since zeros are placed in the right end
        int r = nums1.length - 1;

        // swap is unnecessary
        // just repeat to fill in from the right end
        while (p >= 0 && q >= 0) {
            while (p >= 0 && q >= 0 && nums1[p] <= nums2[q]) {
                nums1[r--] = nums2[q--];
            }
            while (p >= 0 && q >= 0 && nums1[p] >= nums2[q]) {
                nums1[r--] = nums1[p--];
            }
        }

        // flush remaining
        while (r >= 0 && q >= 0) {
            nums1[r--] = nums2[q--];
        }
        while (r >= 0 && p >= 0) {
            nums1[r--] = nums1[p--];
        }
    }
}
