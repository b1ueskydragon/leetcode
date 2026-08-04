package leetcode.p3731;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // 1 <= nums[i] <= 100
        final boolean[] exists = new boolean[101];
        int min = 101;
        int max = 0;
        for (int num : nums) {
            exists[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        final List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!exists[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
