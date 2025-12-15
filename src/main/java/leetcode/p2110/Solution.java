package leetcode.p2110;

class Solution {
    public long getDescentPeriods(int[] prices) {
        int l = 0;
        int r = 1;
        long sum = 0;
        while (r < prices.length) {
            if (prices[r - 1] - prices[r] == 1) {
                // Expand valid window
                r++;
            } else {
                // e.g.,
                // [ ..., 5, 4, 3, ... ]
                // -> [5], [4, 3] [5, 4, 3], [4], [4, 3], [3]
                // -> 3 + 2 + 1 = 6 counts
                sum += (long) (r - l + 1) * (r - l) / 2;
                l = r;
                r++;
            }
        }
        // Handle the last segment
        sum += (long) (r - l + 1) * (r - l) / 2;
        return sum;
    }
}
