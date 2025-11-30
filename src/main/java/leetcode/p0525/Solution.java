package leetcode.p0525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        // 区間の和を求める: prefix sum.
        // The result subarray: (l, r],
        // 0, 1 それぞれの増加幅が同じである区間を見つける.
        // p0[r] - p0[l] == p1[r] - p1[l],
        // もしくは p0[r] - p1[r] == p0[l] - p1[l]
        // になる max(r - l).
        final int n = nums.length;
        final int[] p0 = new int[n];
        final int[] p1 = new int[n];
        // Diff and its [first appearance, last appearance]
        final Map<Integer, int[]> distanceMap = new HashMap<>();

        // Initialize `l` as -1, when diff is 0.
        // e.g.,
        // nums=[0,1],
        // p0 = [1,1],
        // p1 = [1,0]
        // i=1 (diff 0) の時, 予め初期化した l がないと距離が求まらない.
        distanceMap.put(0, new int[]{-1, -1});

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p0[i] = (i == 0) ? 1 : p0[i - 1] + 1;
                p1[i] = (i == 0) ? 0 : p1[i - 1];
            } else {
                p1[i] = (i == 0) ? 1 : p1[i - 1] + 1;
                p0[i] = (i == 0) ? 0 : p0[i - 1];
            }

            final int d = p0[i] - p1[i];
            if (distanceMap.get(d) == null) {
                // Put the first appearance as `l`
                distanceMap.put(d, new int[]{i, -1});
            } else {
                // Update `r`
                distanceMap.put(d, new int[]{distanceMap.get(d)[0], i});
            }
        }

        int diff = 0;
        for (int[] lr : distanceMap.values()) {
            // Single appearance (no `r`)
            if (lr[1] == -1) {
                continue;
            }
            // Get the max `r-l`
            diff = Math.max(diff, lr[1] - lr[0]);
        }

        return diff;
    }
}
