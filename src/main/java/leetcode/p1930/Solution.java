package leetcode.p1930;

class Solution {
    // Unique palindromes of length three.
    // No matter what middle is.
    public int countPalindromicSubsequence(String s) {
        // character -> [index of first occurrence, index of last occurrence]
        final int[][] dict = new int[26][2];
        for (int i = 0; i < 26; i++) {
            dict[i][0] = -1;
            dict[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int v = c - 'a';
            if (dict[v][0] == -1) {
                dict[v][0] = i;
            } else {
                dict[v][1] = i; // Keep to update
            }
        }

        int res = 0;
        // First two characters of palindromes of length three
        final boolean[][] seen = new boolean[26][26];
        for (int i = 0; i < 26; i++) {
            if (dict[i][0] == -1 || dict[i][1] == -1) {
                continue;
            }
            int cnt = 0;
            for (int j = dict[i][0] + 1; j < dict[i][1]; j++) {
                int v = s.charAt(j) - 'a';
                if (seen[i][v]) {
                    continue;
                }
                seen[i][v] = true;
                cnt++;
            }
            res += cnt;
        }

        return res;
    }
}
