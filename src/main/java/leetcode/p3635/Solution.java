package leetcode.p3635;

import java.util.Arrays;

class Solution {
    // A tourist must experience exactly one ride from each category, in either order.
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                getBestMin(landStartTime, landDuration, waterStartTime, waterDuration),
                // Swap the land and the water.
                getBestMin(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int getBestMin(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        final int n = landStartTime.length; // same as landDuration.length
        final int m = waterStartTime.length; // same as waterDuration.length
        int[] landTotal = new int[n];
        int[][] water = new int[m][2];
        for (int i = 0; i < n; i++) {
            landTotal[i] = landStartTime[i] + landDuration[i];
        }
        for (int i = 0; i < m; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
        }

        // e.g,
        // side-n:
        // One of the sums (start + duration) = 10
        //
        // side-m:
        // [2, 99]
        // [2, 100]
        // [9, 12]
        // [10, 8]  <------ 8 is min
        // ------- ↑ less than or equal to 10,  ↓ larget than 10 -------
        // [11, 4]  <-- 15 - 10  <------- 5 is min
        // [33, 11] <-- 44 - 10
        // [44, 22] <-- 66 - 10
        //
        // To find each min effectively, we need prefix/suffix min.
        //
        // min(10 + 8, 10 + 5) = 15.
        //
        // Swap side-n (land) and side-m (water), compare again.

        Arrays.sort(water, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        final int[] prefixMin = new int[m];
        prefixMin[0] = water[0][1];
        for (int i = 1; i < m; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], water[i][1]);
        }
        final int[] suffixMin = new int[m];
        suffixMin[m - 1] = water[m - 1][0] + water[m - 1][1];
        for (int i = m - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], water[i][0] + water[i][1]);
        }

        final int[] sortedWaterStartTime = new int[m];
        for (int i = 0; i < m; i++) {
            sortedWaterStartTime[i] = water[i][0];
        }

        int bestMin = Integer.MAX_VALUE;
        for (int sum : landTotal) {
            // A boundary.
            final int i = binarySearch(sortedWaterStartTime, sum);
            // if i is -1, land-side is too small(short), so same as pick the earliest from the water-side.
            if (i > -1) {
                final int bestBefore = sum + prefixMin[i];
                bestMin = Math.min(bestMin, bestBefore);
            }
            // if i is the last index, there is no target to compare with bestBefore.
            if (i < m - 1) {
                final int bestAfter = suffixMin[i + 1];
                bestMin = Math.min(bestMin, bestAfter);
            }
        }

        return bestMin;
    }

    // Find a boundary index where the value is less than or equal to target.
    private int binarySearch(int[] sorted, int target) {
        int l = 0;
        int r = sorted.length; // Do not -1. l may go +1.
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (sorted[m] <= target) {
                // Maybe the best candidate, however, keep to search.
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
}
