package leetcode.p0057;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // `intervals` is non-overlapping intervals.
    // `intervals` is sorted by start_i in ascending order.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // edge case
        final int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }

        // insert

        final int start = newInterval[0];
        final int end = newInterval[1];
        int pos = 0;
        if (start > intervals[n - 1][0]) {
            pos = n;
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (intervals[i][0] <= start && start <= intervals[i + 1][0]) {
                    pos = i + 1;
                    break;
                }
            }
        }

        final int[][] tmp = new int[n + 1][2];
        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i == pos) {
                tmp[i] = newInterval;
            } else {
                tmp[i] = intervals[index++];
            }
        }

        // merge

        final List<int[]> ansList = new ArrayList<>();
        for (int[] interval : tmp) {
            if (ansList.isEmpty()) {
                ansList.add(interval);
                continue;
            }
            final int[] prev = ansList.getLast();
            // a <= b
            final int a = prev[0];
            final int b = prev[1];
            // a <= c, c <= d
            final int c = interval[0];
            final int d = interval[1];

            if (b < c) {
                ansList.add(interval);
                continue;
            }
            ansList.removeLast();
            ansList.add(new int[]{a, Math.max(b, d)});
        }

        // convert

        final int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
