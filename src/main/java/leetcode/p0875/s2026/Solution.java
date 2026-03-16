package leetcode.p0875.s2026;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // consume k per 1h
        // max k = max(piles)             <-- Max speed. Enough but too fast. We want to consume slowly as we can.
        // min k = ceil(sum(piles) / h)   <-- Average speed. May not be able to consume piles within h, but better than start from 1.
        // answer = the smallest k in [min k, max k]
        // Find the best in a monotonically increasing range, use binary search.
        int max = 0;
        int min = 0;
        for (int p : piles) {
            max = Math.max(p, max);
            min += p;
        }
        min = ceil(min, h);

        // Find the smallest, valid k
        while (min < max) {
            // left-aligned center. Do not fix a left pointer in the middle, or stuck.
            int mid = min + (max - min) / 2;

            int totalH = 0;
            for (int pile : piles) {
                // 10^9 / k,  1 <= k <= 10^9, integer size is enough.
                totalH += ceil(pile, mid);
                if (totalH > h) {
                    break;
                }
            }

            if (totalH > h) {
                // Need to increase consume speed.
                min = mid + 1;
            } else {
                // Feasible, but try to find better (smaller) k.
                max = mid;
            }
        }

        return min;
    }

    private static int ceil(int n, int h) {
        return (n + (h - 1)) / h;
    }
}
