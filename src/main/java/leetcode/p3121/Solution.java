package leetcode.p3121;

class Solution {
    public int numberOfSpecialChars(String word) {
        final boolean[] x = new boolean[26]; // lowercases.
        final boolean[] y = new boolean[26]; // uppercases.
        final boolean[] z = new boolean[26]; // exceptions.
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                x[c - 'a'] = true;
                if (y[c - 'a']) {
                    z[c - 'a'] = true;
                }
            }
            if (c >= 'A' && c <= 'Z') {
                y[c - 'A'] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (x[i] && y[i] && !z[i]) {
                count++;
            }
        }
        return count;
    }
}
