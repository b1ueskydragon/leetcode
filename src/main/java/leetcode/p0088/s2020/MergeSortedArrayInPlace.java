package leetcode.p0088.s2020;

public class MergeSortedArrayInPlace {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    while (m > 0 && n > 0) {
      // copy the largest value at that point to the rightmost side.
      if (nums1[m - 1] >= nums2[n - 1]) {
        nums1[m + n - 1] = nums1[m - 1];
        m -= 1;
      } else {
        nums1[m + n - 1] = nums2[n - 1];
        n -= 1;
      }
    }
    // copy nums2 to nums1 if remains.
    for (int i = 0; i < n; i++) {
      nums1[i] = nums2[i];
    }
  }
}
