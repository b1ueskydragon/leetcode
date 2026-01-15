package leetcode.p0069;

class Solution {
    public int mySqrt(int x) {
        int lo = (x == 0) ? 0 : 1;
        int hi = x;
        int ans = lo;
        while (lo < hi) {
            // left-aligned center. Do not fix a left in the middle.
            int m = lo + (hi - lo) / 2;
            // To avoid overflow, transform m * m <= x to m <= x / m.
            if (m <= x / m) {
                // Record first, and search a better candidate.
                // The answer is not a closer number, we must round down in any case.
                // Lower must be a standard.
                ans = m;
                lo = m + 1;
            } else {
                hi = m;
            }
        }
        return ans;
    }
}
