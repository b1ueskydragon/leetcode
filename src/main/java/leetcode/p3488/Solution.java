package leetcode.p3488;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        final int n = nums.length;
        final List<Integer> ans = new ArrayList<>(queries.length);
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            // Add indices from left to right, the list is always sorted ascending.
            map.get(nums[i]).add(i);
        }
        // System.out.println(map);

        // query 自体は循環しない.
        // 0 <= queries[i] < nums.length
        for (int i : queries) {
            int v = nums[i];
            List<Integer> sorted = map.get(v);
            final int m = sorted.size();

            if (m == 1) {
                // unique.
                ans.add(-1);
                continue;
            }

            int j = lowerBoundBS(sorted, i);

            // compute distance.
            if (j == m) {
                int forward = n - i + sorted.get(0);
                int backward = sorted.get(m - 1) - sorted.get(m - 2);
                ans.add(Math.min(forward, backward));
                continue;
            }
            int forward = sorted.get(j) - i;
            int k = upperBoundBS(sorted, i);
            int backward = (k == -1) ? n - sorted.get(m - 1) + sorted.get(0) : i - sorted.get(k);
            // System.out.printf("nums[%s]: %s %s %n", i, forward, backward);
            ans.add(Math.min(forward, backward));
        }

        return ans;
    }

    // Greater than target.
    private int lowerBoundBS(List<Integer> sorted, int target) {
        final int n = sorted.size();
        int l = 0;
        // left-aligned center で lowerBound なのではみ出ない.
        int r = n - 1;
        if (sorted.get(r) <= target) {
            return n;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sorted.get(m) <= target) {
                l = m + 1;
            } else {
                // このまま answer の可能性もある.
                r = m;
            }
        }
        return r;
    }

    // Lower than target.
    private int upperBoundBS(List<Integer> sorted, int target) {
        final int n = sorted.size();
        int l = 0;
        // left-aligned center で lowerBound なのではみ出る.
        int r = n;
        if (sorted.get(0) >= target) {
            return -1;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sorted.get(m) >= target) {
                r = m;
            } else {
                // このまま answer の可能性もある.
                l = m + 1;
            }
        }
        return l - 1; // l は行きすぎる.
    }
}
