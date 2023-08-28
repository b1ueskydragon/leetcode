package leetcode.p0646;

import java.util.Arrays;

class Solution {
    private int maxCount = 0;

    public int findLongestChain(int[][] pairs) {
        sortInplace(pairs);
        rec(pairs, 0, 0);
        // increase afterwards since the start point is not included
        return maxCount + 1;
    }

    private void rec(int[][] sortedPairs, int start, int count) {
        for (int i = start; i < sortedPairs.length; i++) {
            final int[] pair = sortedPairs[i];
            int j = i + 1;
            while (j < sortedPairs.length) {
                final int[] nextPair = sortedPairs[j];
                if (pair[1] < nextPair[0]) {
                    // going deeper
                    // a counter which be held in each single recursion process
                    // and hence count++ is a incorrect usage
                    rec(sortedPairs, j, count + 1);
                }
                j++;
            }
            maxCount = (count < maxCount) ? maxCount : count;
        }
    }

    private void sortInplace(int[][] pairs) {
        // sorting by xs[1], ys[1] is unnecessary
        // since smaller is not always preferred
        Arrays.sort(pairs, (xs, ys) -> xs[0] - ys[0]);
    }
}
