package leetcode.p2785;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Solution {

    // Get a new string.

    private static final Set<Character> dict = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

    public String sortVowels(String s) {
        final int n = s.length();

        final List<Integer> vs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (dict.contains(c)) {
                vs.add(i);
            }
        }

        final Character[] vowels = new Character[vs.size()];
        int j = 0;
        for (char c : s.toCharArray()) {
            if (dict.contains(c)) {
                vowels[j++] = c;
            }
        }

        // 'A' to 'Z' come first than 'a' to 'z'
        Arrays.sort(vowels);

        final char[] t = s.toCharArray();
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (dict.contains(t[i])) {
                t[i] = vowels[k++];
            }
        }

        return new String(t);
    }
}
