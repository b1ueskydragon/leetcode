package leetcode.p3136;

import java.util.Set;

class Solution {

    private static final Set<Character> V_DICT = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean isValid(String word) {
        final int n = word.length();
        if (n < 3) {
            return false;
        }
        int consonants = 0;
        int vowels = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!isNum(c) && !isLowerCase(c) && !isUpperCase(c)) {
                return false;
            }
            if (isNum(c)) {
                continue;
            }
            if (V_DICT.contains(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return consonants > 0 && vowels > 0;
    }

    private static boolean isNum(char c) {
        return c >= 48 && c <= 57;
    }

    private static boolean isLowerCase(char c) {
        return c >= 97 && c <= 122;
    }

    private static boolean isUpperCase(char c) {
        return c >= 65 && c <= 90;
    }

}
