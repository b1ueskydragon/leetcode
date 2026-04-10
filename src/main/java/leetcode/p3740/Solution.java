package leetcode.p3740;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // nums[i] == nums[j] == nums[k],
    // abs(i - j) + abs(j - k) + abs(k - i)
    // i < j < k なら, (k - i) * 2 で求まる. その中で find the minimum.
    public int minimumDistance(int[] nums) {
        // Constraints:
        // 1 <= n <= 100
        // 1 <= nums[i] <= n
        final int n = nums.length;
        // num -> {i, j, k, .. }
        List[] appearance = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            appearance[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            appearance[nums[i]].add(i);
        }

        int best = 200; // Unreachable due to the constraints.

        for (List<Integer> list : appearance) {
            final int m = list.size();
            if (m < 3) {
                continue;
            }
            for (int i = 0; i < m - 2; i++) {
                best = Math.min(best, (list.get(i + 2) - list.get(i)) * 2);
            }
        }
        return best == 200 ? -1 : best;
    }
}
