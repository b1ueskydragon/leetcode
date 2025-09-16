package leetcode.p1935;

class Solution {

    static class V2 {

        public int canBeTypedWords(String text, String brokenLetters) {
            int mask = 0;
            //  0     ...    0    0    0    0
            //  z(26) ...    d(3) c(2) b(1) a(0)
            // if broken, set the bit to 1
            for (char c : brokenLetters.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            int sum = 0;
            for (String word : text.split(" ")) {
                sum += canBeTypedWord(word, mask);
            }

            return sum;
        }

        private static int canBeTypedWord(String word, int mask) {
            for (char c : word.toCharArray()) {
                final int curr = 1 << (c - 'a');
                if ((curr & mask) == curr) {
                    // matched
                    return 0;
                }
            }
            return 1;
        }

    }


    static class V1 {

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

}
