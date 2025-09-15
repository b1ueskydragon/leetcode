package leetcode.p1935;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        final boolean[] isAbsent = buildDict(brokenLetters);
        final String[] words = text.split(" ");
        int sum = 0;
        for (String word : words) {
            sum += canType(word, isAbsent);
        }
        return sum;
    }

    private static boolean[] buildDict(String brokenLetters) {
        // Only consists of lowercase English letters
        final boolean[] isAbsent = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            isAbsent[c - 'a'] = true;
        }
        return isAbsent;
    }

    private static int canType(String s, boolean[] isAbsent) {
        for (char c : s.toCharArray()) {
            if (isAbsent[c - 'a']) {
                return 0;
            }
        }
        return 1;
    }
}
