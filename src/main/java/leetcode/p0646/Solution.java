package leetcode.p0646;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        sortInplace(pairs);
        final int[] countFrom = new int[pairs.length];
        int maxChain = 0;
        for (int i = 0; i < pairs.length; i++) {
            maxChain = Math.max(maxChain, countChain(pairs, i, countFrom));
        }
        return maxChain;
    }

    // separate as a subroutine
    // countFrom[i] := the number of chains starting from the index i (i is inclusive). i is from the sortedPairs
    private int countChain(int[][] sortedPairs, int start, int[] countFrom) {
        // base case
        // the last pair (a leaf node) itself should be counted as 1
        if (start == sortedPairs.length - 1) {
            return 1;
        }
        // memoization
        // to prevent retrieve same tail path over and over
        // the number of chains is already known from each starting point
        if (countFrom[start] > 0) {
            return countFrom[start];
        }
        for (int j = start + 1; j < sortedPairs.length; j++) {
            final int pairRight = sortedPairs[start][1];
            final int nextPairLeft = sortedPairs[j][0];
            // the only condition which can build the chain
            if (pairRight < nextPairLeft) {
                // going deeper
                // basically, retrieving all nodes is required
                final int countTailChain = countChain(sortedPairs, j, countFrom);
                // update to the latest count as the number of chains from the starting point, if needed
                countFrom[start] = Math.max(countFrom[start], countTailChain + 1);
            }
        }
        return countFrom[start];
    }

    private void sortInplace(int[][] pairs) {
        // sorting by xs[1], ys[1] is unnecessary
        // since smaller is not always preferred
        Arrays.sort(pairs, (xs, ys) -> xs[0] - ys[0]);
    }
}
