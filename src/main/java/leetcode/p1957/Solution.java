package leetcode.p1957;

class Solution {
    // Make `s` without any three consecutive characters
    public String makeFancyString(String s) {
        // `s` consists only of lowercase English letters
        final int[] freq = new int[26];
        final var sb = new StringBuilder();
        char prev = '$';
        for (char c : s.toCharArray()) {
            if (prev != c) {
                // not consecutive, reset
                freq[c - 97] = 0;
            }
            freq[c - 97]++;
            prev = c;
            if (freq[c - 97] > 2) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
