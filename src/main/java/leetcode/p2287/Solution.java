package leetcode.p2287;

class Solution {
    // s and target consist of lowercase English letters.
    public int rearrangeCharacters(String s, String target) {
        final int[] sourceFreq = new int[26];
        for (char c : s.toCharArray()) {
            sourceFreq[c - 'a']++;
        }
        final int[] targetFreq = new int[26];
        final char[] t = target.toCharArray();
        for (char c : t) {
            targetFreq[c - 'a']++;
        }
        int required = Integer.MAX_VALUE;
        for (char c : t) {
            required = Math.min(required, sourceFreq[c - 'a'] / targetFreq[c - 'a']);
        }
        return required;
    }
}
