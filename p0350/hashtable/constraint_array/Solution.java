package leetcode.p0350.hashtable.constraint_array;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // Constraints
  // 1 <= nums1.length, nums2.length <= 1000
  // 0 <= nums1[i], nums2[i] <= 1000
  public int[] intersect(int[] nums1, int[] nums2) {
    final int[] table = new int[1001];

    for (int num : nums1) {
      table[num]++;
    }

    final List<Integer> list = new ArrayList<>();

    for (int num : nums2) {
      if (table[num] == 0) {
        continue;
      }
      list.add(num);
      table[num]--;
    }

    final int[] res = new int[list.size()];
    int i = 0;
    for (int v : list) {
      res[i++] = v;
    }

    return res;
  }
}
