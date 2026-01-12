package leetcode.p1266;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // (1) Adjust (x, y) at the same time is the best. 4 patterns: (+1, +1), (-1, -1), (+1, -1), (-1, +1).
        // (2) Once any one side fixed by (1), then move the other one alone is the best.
        int[] prev = points[0];
        int p1 = prev[0];
        int p2 = prev[1];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            int c1 = curr[0];
            int c2 = curr[1];

            int diff1 = Math.abs(c1 - p1);
            int diff2 = Math.abs(c2 - p2);
            // e.g.,
            // (1,1) -> (3,4)
            // (1,1) -> (2,2) -> (3,3) -> (3,4)
            // 結局大きい方に合わせられる.
            count += Math.max(diff1, diff2);

            // // (1)
            // while (p1 < c1 && p2 < c2) {
            //     p1++;
            //     p2++;
            //     count++;
            // }
            // while (p1 > c1 && p2 > c2) {
            //     p1--;
            //     p2--;
            //     count++;
            // }
            // while (p1 < c1 && p2 > c2) {
            //     p1++;
            //     p2--;
            //     count++;
            // }
            // while (p1 > c1 && p2 < c2) {
            //     p1--;
            //     p2++;
            //     count++;
            // }

            // // (2)
            // while (p1 == c1 && p2 > c2) {
            //     p2--;
            //     count++;
            // }
            // while (p1 == c1 && p2 < c2) {
            //     p2++;
            //     count++;
            // }
            // while (p1 > c1 && p2 == c2) {
            //     p1--;
            //     count++;
            // }
            // while (p1 < c1 && p2 == c2) {
            //     p1++;
            //     count++;
            // }

            p1 = c1;
            p2 = c2;
        }
        return count;
    }
}
