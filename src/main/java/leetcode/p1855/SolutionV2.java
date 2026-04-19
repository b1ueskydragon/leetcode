package leetcode.p1855;

class SolutionV2 implements Solution {

    public int maxDistance(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        int i = n - 1;
        final int m = nums2.length;
        int j = m - 1;

        int best = 0;
        while (i >= 0) {
            while (i <= j && nums2[j] < nums1[i]) {
                j--;
            }
            // System.out.printf("%s %s %n", i, j);
            if (i <= j) {
                best = Math.max(best, j - i);
            }
            i--;
        }
        return best;
    }

}
