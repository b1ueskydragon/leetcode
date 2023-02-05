package leetcode.p0219;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // mapping value -> start pos
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                continue;
            }
            final int start = map.get(nums[i]);
            if (i - start <= k) {
                // found any. early return
                return true;
            }
            // set a new start pos
            map.put(nums[i], i);
        }
        return false;
    }
}
