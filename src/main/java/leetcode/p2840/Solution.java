package leetcode.p2840;

class Solution {
    // Choose any two indices i and j such that i < j and the difference j - i is even.
    public boolean checkStrings(String s1, String s2) {
        // Swaps are allowed by skipping an even number from each position, and the swap count is not a matter,
        // In other words, odd index can swap with odd indices, even can with even.
        final int[] evenIdxFreq = new int[26]; // a-z
        final int[] oddIdxFreq = new int[26]; // a-z
        for (int i = 0; i < s1.length(); i++) {
            int v = s1.charAt(i) - 'a';
            if ((i & 1) == 0) {
                evenIdxFreq[v]++;
            } else {
                oddIdxFreq[v]++;
            }
        }
        // len(s1) == len(s2)
        // s2: standard.
        // s1: try to fit to s2.
        for (int i = 0; i < s1.length(); i++) {
            int v = s2.charAt(i) - 'a';
            if ((i & 1) == 0) {
                evenIdxFreq[v]--;
            } else {
                oddIdxFreq[v]--;
            }
            if (evenIdxFreq[v] < 0 || oddIdxFreq[v] < 0) {
                return false;
            }
        }

        return true;
    }
}
