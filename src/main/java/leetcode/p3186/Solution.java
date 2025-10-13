package leetcode.p3186;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 1 <= len(power) <= 10^5
    // 1 <= power[i] <= 10^9
    // Since values up to 1e9, array indexing is not feasible; use HashMap
    public long maximumTotalDamage(int[] power) {
        // curr-2, curr-1, curr+1, curr+2 と conflict を起こす状態が多いので
        // 先にソートして curr-2, curr-1 と見る順序を一方向に整える必要がある
        // (未来との conflict を考えない)

        // e.g.,
        // power = [7, 1, 6, 6]
        // sortedUniquePower = [1, 6, 7]
        // prevMaxIndex = [-1, 0, 0] (To find the valid value effectively)
        // weight = [1*1, 6*2, 7*1]

        // Count each value
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        // Sort each value to ascending order
        // weight = value * frequency
        // We only keep unique values
        final int m = freq.size();
        final int[] sortedUniquePower = new int[m];
        // Integer.MAX_VALUE < 10^9 * 10^5 < Long.MAX_VALUE
        // weight aligns with sortedUniquePower (should be same order)
        final long[] weight = new long[m];
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        for (int i = 0; i < m; i++) {
            final int v = keys.get(i);
            sortedUniquePower[i] = v;
            weight[i] = v * (long) freq.get(v);
        }

        // prevMaxIndex[i] = last j (<i) with sortedUniquePower[j] <= sortedUniquePower[i] - 3
        final int[] prevMaxIndex = new int[m];
        // Since l increases monotonically, Time complexity is O(m)
        int l = 0;
        for (int i = 0; i < m; i++) {
            // e.g., sortedUniquePower[i]=7 -> target=4
            final int target = sortedUniquePower[i] - 3;
            while (l < i) {
                if (sortedUniquePower[l] > target) {
                    // Found
                    break;
                }
                l++;
            }
            // l stops at the first index with sortedUniquePower[l] > target, so prev = l-1
            // If there is no valid value before the current (e.g., sortedUniquePower[0]), put -1 as a previous valid index
            prevMaxIndex[i] = l - 1;
        }

        final long[] dp = new long[m];
        for (int i = 0; i < m; i++) {
            final int j = prevMaxIndex[i];
            long take = (j < 0) ? weight[i] : weight[i] + dp[j];
            long notTake = (i < 1) ? 0 : dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[m - 1];
    }
}
