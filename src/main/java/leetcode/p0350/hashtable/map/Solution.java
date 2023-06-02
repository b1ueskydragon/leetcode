package leetcode.p0350.hashtable.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    final Map<Integer, Integer> map1 = new HashMap<>();

    for (int num : nums1) {
      map1.putIfAbsent(num, 0);
      map1.put(num, map1.get(num) + 1);
    }

    final Map<Integer, Integer> map2 = new HashMap<>();

    for (int num : nums2) {
      map2.putIfAbsent(num, 0);
      map2.put(num, map2.get(num) + 1);
    }

    final List<Integer> list = new ArrayList<>();

    for (int num : map1.keySet()) {
      if (!map2.containsKey(num)) {
        continue;
      }
      for (int i = 0; i < Math.min(map1.get(num), map2.get(num)); i++) {
        list.add(num);
      }
    }

    final int[] res = new int[list.size()];
    int i = 0;
    for (int num : list) {
      res[i++] = num;
    }

    return res;
  }
}
