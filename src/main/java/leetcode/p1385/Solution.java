package leetcode.p1385;

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // e.g.,
        // d=2, arr1[i]=5,
        // count 5 only if arr2 contains no value in {3,4,5,6,7}.
        Arrays.sort(arr2);
        int count = 0;
        for (int num : arr1) {
            final int min = num - d; // range inclusive
            final int max = num + d; // range inclusive
            if (min > arr2[arr2.length - 1]) {
                count++;
                continue;
            }
            if (max < arr2[0]) {
                count++;
                continue;
            }
            final int l = searchOrGreaterThanValue(arr2, min); // find an index
            final int r = searchOrLesserThatValue(arr2, max); // find an index

            if (l > r) {
                count++;
            }
        }
        return count;
    }

    private int searchOrGreaterThanValue(int[] sorted, int value) {
        int l = 0;
        int r = sorted.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2; // left-align center
            if (sorted[m] >= value) { // m also can be the candidate
                r = m;
            } else {
                l = m + 1; // do not fix l in the middle
            }
        }
        return r;
    }

    private int searchOrLesserThatValue(int[] sorted, int value) {
        int l = 0;
        int r = sorted.length; // since we need to return r-1
        while (l < r) {
            int m = l + (r - l) / 2; // left-align center
            if (sorted[m] > value) { // m cannot be the candidate
                r = m;
            } else { // m also can be the candidate
                l = m + 1; // but do not fix l in the middle
            }
        }
        return r - 1;
    }
}
