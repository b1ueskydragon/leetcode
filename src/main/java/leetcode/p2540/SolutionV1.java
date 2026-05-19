package leetcode.p2540;

class SolutionV1 implements Solution {

    public int getCommon(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        int i = 0;
        int j = 0;
        // O(m + n)
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

}
