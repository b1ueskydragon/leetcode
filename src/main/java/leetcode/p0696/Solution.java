package leetcode.p0696;

class Solution {
    public int countBinarySubstrings(String s) {
        // e.g.,
        // 000111
        // left count (000) = 3, right count (111) = 3
        // Same number of 0's and 1's, and grouped by each oterh patterns:
        // 01, 0011, 000111
        // 3 patterns, same as the number of each 0's or 1's.
        //
        // 0000111
        // left count (0000) = 4, right count (111) = 3
        // Must follow the shorter length, same as 000111.

        char prev = s.charAt(0);

        int prevCount = 0;
        int count = 1;

        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev == curr) {
                count++;
            } else {
                ans += Math.min(prevCount, count);
                prevCount = count;
                count = 1;
            }
            prev = curr;
        }

        return ans + Math.min(prevCount, count);
    }
}
