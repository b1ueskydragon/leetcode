package leetcode.p0350.sort_array;

import java.util.Arrays;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    final int n = nums1.length;
    final int m = nums2.length;

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    final int[] ary = new int[Math.min(n, m)];
    int i = 0;

    int i1 = 0;
    int i2 = 0;
    while (i2 < m && i1 < n) {
      if (nums2[i2] == nums1[i1]) {
        ary[i++] = nums2[i2];
        i1++;
        i2++;
      } else if (nums2[i2] < nums1[i1]) {
        i2++;
      } else {
        i1++;
      }
    }

    return Arrays.copyOfRange(ary, 0, i);
  }
}
