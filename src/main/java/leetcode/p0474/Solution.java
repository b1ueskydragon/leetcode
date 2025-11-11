package leetcode.p0474;

class Solution {
    // The largest subset (not contiguous)
    // At most m and n

    private static Pair[] freq;
    private static Integer[][][] memo; // To utilize null, use Integer type

    public int findMaxForm(String[] strs, int m, int n) {
        freq = buildFrequencyMap(strs);
        memo = new Integer[strs.length + 1][m + 1][n + 1];
        return count(0, 0, 0, m, n);
    }

    // pick, not-pick dfs
    private static int count(int i, int currM, int currN, int m, int n) {
        if (i == freq.length) {
            // Base case
            return 0;
        }
        if (memo[i][currM][currN] != null) {
            return memo[i][currM][currN];
        }

        // Not-pick (skip)
        int best = count(i + 1, currM, currN, m, n);

        // Pick (Note: only if pickable)
        if (currM + freq[i].zeros <= m && currN + freq[i].ones <= n) {
            best = Math.max(best, 1 + count(i + 1, currM + freq[i].zeros, currN + freq[i].ones, m, n));
        }

        memo[i][currM][currN] = best;
        return best;
    }


    private static Pair[] buildFrequencyMap(String[] strs) {
        final Pair[] freq = new Pair[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            freq[i] = new Pair(zeros, ones);
        }
        return freq;
    }

    private static class Pair {
        int zeros;
        int ones;

        Pair(int zeros, int ones) {
            this.zeros = zeros;
            this.ones = ones;
        }
    }
}
