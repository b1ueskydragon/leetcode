package leetcode.p3186;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // 1 <= len(power) <= 10^5
    // 1 <= power[i] <= 10^9
    // Array indexing is not feasible (values up to 10^9), use HashMap

    static class V2 {
        /**
         * O(n + m log m) Time Complexity, where m is unique values.
         * - O(n): Frequency counting
         * - O(m log m): Sorting + DP with binary search
         * - Worst case: O(n log n) when m = n
         * O(m) Space Usage.
         */
        public long maximumTotalDamage(int[] power) {
            // Count to compress values
            // We will only keep unique values
            final Map<Integer, Integer> freq = new HashMap<>();
            for (int p : power) {
                freq.put(p, freq.getOrDefault(p, 0) + 1);
            }

            // Sort each value to ascending order
            // weight = value * frequency
            List<Integer> uniquePowerAsc = new ArrayList<>(freq.keySet());
            Collections.sort(uniquePowerAsc);

            // m is a size of unique values
            // Same as freq#size
            final int m = uniquePowerAsc.size();
            final long[] dp = new long[m];

            for (int i = 0; i < m; i++) {
                final int curr = uniquePowerAsc.get(i);
                final long weightedCurr = (long) curr * freq.get(curr);

                // Find last non-conflicting position
                // dp[j] is non-conflict maximum previous result
                final int j = binarySearch(uniquePowerAsc, curr - 3);

                long notTake = (i < 1) ? 0 : dp[i - 1];
                long take = (j < 0) ? weightedCurr : dp[j] + weightedCurr;
                dp[i] = Math.max(notTake, take);
            }

            return dp[m - 1];
        }

        private static int binarySearch(List<Integer> numAsc, int target) {
            int l = 0;
            // target が numAsc の右端よりも大きい場合対策
            // Only m can access to numAsc
            int r = numAsc.size();
            // target がない場合, target より小さいものの中で最も右(大きい)ものを返す
            // If value > target, it conflicts (distance < 3)
            while (l < r) {
                final int m = l + (r - l) / 2;
                if (numAsc.get(m) == target) {
                    return m;
                }
                if (numAsc.get(m) > target) {
                    r = m;
                } else {
                    // Since m is left-aligned mid, we must not fix l
                    l = m + 1;
                }
            }
            // 終了時 l==r
            // l points to the first element > target, so return l-1
            return l - 1;
        }
    }

    static class V1 {

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

}
