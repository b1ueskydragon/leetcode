package leetcode.p0017.s202205.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {
    private static final Map<Character, String[]> letterMap
            = Map.of(
            '2', new String[]{"a", "b", "c"},
            '3', new String[]{"d", "e", "f"},
            '4', new String[]{"g", "h", "i"},
            '5', new String[]{"j", "k", "l"},
            '6', new String[]{"m", "n", "o"},
            '7', new String[]{"p", "q", "r", "s"},
            '8', new String[]{"t", "u", "v"},
            '9', new String[]{"w", "x", "y", "z"});

    public List<String> letterCombinations(String digits) {
        final int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        return letterCombinations(n - 1, digits);
    }

    private List<String> letterCombinations(int k, String digits) {
        String[] currLetter = letterMap.get(digits.charAt(k));
        if (k == 0) {
            return Arrays.asList(currLetter);
        }
        // a combination result of current stage
        // should be mutable
        List<String> res = new ArrayList<>();

        List<String> prevCombs = letterCombinations(k - 1, digits);
        for (String p : prevCombs) {
            for (String s : currLetter) {
                res.add(p + s);
            }
        }
        return res;
    }
}
