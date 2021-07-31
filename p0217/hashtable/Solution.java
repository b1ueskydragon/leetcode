package leetcode.p0217.hashtable;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    final Set<Integer> set = new HashSet<>(nums.length); // set an initialCapacity
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }
}
