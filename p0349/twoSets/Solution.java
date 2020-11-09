package leetcode.p0349.twoSets;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    final Set<Integer> set1 = new HashSet<>();
    for (int x : nums1) {
      set1.add(x);
    }

    final Set<Integer> res = new HashSet<>();
    for (int y : nums2) {
      if (set1.contains(y)) {
        res.add(y);
      }
    }

    final int[] result = new int[res.size()];
    int i = 0;
    for (int num : res) {
      result[i++] = num;
    }

    return result;
  }
}
