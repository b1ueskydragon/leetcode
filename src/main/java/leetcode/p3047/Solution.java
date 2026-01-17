package leetcode.p3047;

class Solution {
    // Regardless of the size of the element itself,
    // n <= 1000, brute force is still feasible.
    //
    // Rectangle ⊃ Square,
    // an area of square = (短い辺)^2
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        final int n = bottomLeft.length; // Equivalent to topRight.length
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (topRight[i][0] <= bottomLeft[j][0]
                        || topRight[j][0] <= bottomLeft[i][0]
                        || topRight[i][1] <= bottomLeft[j][1]
                        || topRight[j][1] <= bottomLeft[i][1]) {
                    // Non-overlapped.
                    ans = Math.max(ans, 0);
                    continue;
                }

                // 1D line, (a1, a2), (b1, b2)
                // To meet x > a1 AND x > b1,
                // x > max(a1, b1)
                // Another 1D line, (c1, c2), (d1, d2)
                // To meet x < c1 AND x < d1,
                // x < min(c1, d1)
                // -> max(a1, b1) < x < min(c1, d1)
                // -> width (the possible range of x) is min(c1, d1) - max(a1, b1)
                int x = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                // 1D line, (a1, a2), (b1, b2)
                // To meet y < a2 AND y < b2,
                // y < min(a2, b2)
                // Another 1D line, (c1, c2), (d1, d2)
                // To meet y > c2 AND y > d2
                // y > max(c2, d2)
                // -> max(c2, d2) < y < min(a2, b2)
                // -> height (the possible range of y) is min(a2, b2) - max(c2, d2)
                int y = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                long s = Math.min(x, y);
                ans = Math.max(ans, s * s);
            }
        }
        return ans;
    }
}
