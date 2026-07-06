package leetcode.p1288;

import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Order as [[1,9],[1,5],[1,4],[2,8],[2,4],[3,6]]
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]
                ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        final int n = intervals.length;
        int[] head = intervals[0];
        int i = 1;
        int count = 0;
        while (i < n) {
            int[] pair = intervals[i];
            if (head[0] <= pair[0] && head[1] >= pair[1]) {
                // Covered intervals count.
                count++;
            } else {
                head = pair;
            }
            i++;
        }
        return n - count;
    }
}
