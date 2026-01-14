package leetcode.p1011;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 求めるもの: Capacity
        // min capacity: max(weights) ... これを下回るとそもそも運べない weight がある
        // max capacity: sum(weights) ... 最短 1 day で運べる capacity
        // [min, max] の間の最適な capacity を求める.
        // min < 最適解 < max
        // -> Binary search
        int lo = 0; // max
        int hi = 0; // sum
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        int best = hi; // ここからギリギリまで capacity を減らしていく.
        while (lo < hi) {
            // left-aligned center. Do not fit left cursor in the middle.
            int m = lo + (hi - lo) / 2;
            if (!isFeasible(m, weights, days)) {
                // Need to get additional capacity.
                lo = m + 1;
            } else {
                // Record the best so far.
                best = m;
                // Then find a better candidate.
                hi = m;
            }
        }
        return best;
    }

    // Greedy. Load weights left to right.
    private static boolean isFeasible(int capacity, int[] weights, int days) {
        int dayNeeded = 0;
        int load = 0;
        for (int w : weights) {
            if (load + w > capacity) {
                load = 0;
                dayNeeded++;
                if (dayNeeded > days) {
                    // Already exceeded.
                    return false;
                }
            }
            load += w;
        }
        if (load > 0) {
            dayNeeded++;
        }
        return dayNeeded <= days;
    }
}
