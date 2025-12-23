package leetcode.p2054;

import java.util.Arrays;

class Solution {
    // If you attend an event with end time t, the next event must start at or after t + 1.
    // Choose at most two events.
    public int maxTwoEvents(int[][] events) {
        final int n = events.length;
        // Sort by start time (to use binary search later)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Suffix max
        final int[] suffixMaxRewards = new int[n];
        suffixMaxRewards[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            suffixMaxRewards[i] = Math.max(events[i][2], suffixMaxRewards[i + 1]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = events[i][1];
            // 結局 value だけわかれば良いのと, suffix-max でその位置以後の max value がわかるので
            // 最初の t+1 以上の start を見つけることで OK
            int j = binarySearch(events, i, t + 1);

            max = (events[i][1] >= events[j][0]) ?
                    Math.max(max, events[i][2]) // `j` not found
                    : Math.max(max, events[i][2] + suffixMaxRewards[j]); // `j` found
        }

        return max;
    }

    // Find the first index that its value is equal or larger than target in sorted array.
    private static int binarySearch(int[][] events, int i, int target) {
        int l = i;
        int r = events.length - 1;
        while (l < r) {
            // Left-aligned pivot.
            // We shouldn't fix the left on the pivot (otherwise, it will be stuck).
            int m = l + (r - l) / 2;
            if (target > events[m][0]) {
                // The end time (target) should be earlier than the start time
                l = m + 1;
            } else {
                // Still we can search "smaller" one.
                r = m;
            }
        }
        return l;
    }
}
