package leetcode.p3471;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
class Solution2026V1 {
    public int largestInteger(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        final int n = nums.length;
        final Set[] exists = new Set[51];
        while (r < n) {
            for (int i = l; i < l + k; i++) {
                if (exists[nums[i]] == null) {
                    exists[nums[i]] = new HashSet<>();
                }
                exists[nums[i]].add(l);
            }
            r++;
            l = r - k + 1;
        }
        int ans = -1;
        for (int num = 0; num < 51; num++) {
            if (exists[num] == null) {
                continue;
            }
            if (exists[num].size() == 1) {
                ans = num;
            }
        }
        return ans;
    }
}
