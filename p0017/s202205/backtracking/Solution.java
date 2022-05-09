package leetcode.p0017.s202205.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    private static final Map<Character, List<String>> letterMap
            = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        final int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        return letterCombinations(n, n - 1, getKeys(digits));
    }

    private List<String> letterCombinations(int n, int k, char[] digits) {
        // should be mutable
        List<String> res = new ArrayList<>();
        if (k == 0) {
            res.addAll(letterMap.get(digits[0]));
            return res;
        }

        List<String> prevCombs = letterCombinations(n, k - 1, digits);
        List<String> currLetter = letterMap.get(digits[k]);
        for (String p : prevCombs) {
            for (String s : currLetter) {
                res.add(p + s);
            }
        }

        return res;
    }

    private static char[] getKeys(String digits) {
        final int n = digits.length();
        final char[] keys = new char[n];
        for (int i = 0; i < n; i++) {
            keys[i] = digits.charAt(i);
        }
        return keys;
    }
}
