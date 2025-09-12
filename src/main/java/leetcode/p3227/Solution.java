package leetcode.p3227;

import java.util.Set;

class Solution {

    private static final Set<Character> dict = Set.of('a', 'e', 'i', 'o', 'u');

    public boolean doesAliceWin(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (dict.contains(c)) {
                count++;
            }
        }

        if (count == 0) {
            // 0 vowel
            // Bob wins
            return false;
        }

        if ((count & 1) == 1) {
            // Odd vowels
            // Alice wins
            return true;
        }

        // Even vowels

        // When remaining after pick is:
        // - even vowels or 0 vowel -> Bob wins
        // - odd vowels -> Alice wins
        // However, odd + odd is always even...
        return true;
    }

}
