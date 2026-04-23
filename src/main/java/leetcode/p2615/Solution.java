package leetcode.p2615;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        final Map<Integer, List<Long>> map = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add((long) i);
        }

        final long[] ans = new long[n];

        for (List<Long> indices : map.values()) {
            if (indices.size() == 1) {
                // ans[indices.getFirst().intValue()] = 0;
                continue;
            }
            final long[] diffs = new long[indices.size() - 1];
            for (int i = 0; i < indices.size() - 1; i++) {
                diffs[i] = indices.get(i + 1) - indices.get(i);
            }
            long prefixSum = 0;
            for (int i = 0; i < indices.size(); i++) {
                prefixSum += (indices.get(i) - indices.getFirst());
            }
            long suffixSum = 0;
            for (int i = indices.size() - 1; i >= 0; i--) {
                suffixSum += (indices.getLast() - indices.get(i));
            }
            // 0, 2, 3, 6 (appearance indices)
            //   2  1  3  (diffs)
            // 0:           2 + 3 + 6 <--- 2 + 3 + 6 is the initial prefixSum.
            // 2:  2          + 1 + 4 <--- 1 + 4 == (2 - 2) + (3 - 2) + (6 - 2)
            // 3:  3 + 1          + 3 <---     3 == (1 - 1) + (4 - 1)
            // 6:  6 + 4 + 3
            for (int i = 0; i < indices.size(); i++) {
                final int index = indices.get(i).intValue();
                prefixSum = (i == 0) ? prefixSum : prefixSum - (diffs[i - 1] * (indices.size() - i));
                ans[index] = prefixSum;
            }
            for (int i = indices.size() - 1; i >= 0; i--) {
                final int index = indices.get(i).intValue();
                suffixSum = (i == indices.size() - 1) ? suffixSum : suffixSum - (diffs[i] * (i + 1));
                ans[index] += suffixSum;
            }
        }

        return ans;
    }
}
