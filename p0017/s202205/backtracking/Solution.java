package leetcode.p0017.s202205.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static final String[][] letterMap =
            new String[][]{
                    {},
                    {},
                    {"a", "b", "c"},
                    {"d", "e", "f"},
                    {"g", "h", "i"},
                    {"j", "k", "l"},
                    {"m", "n", "o"},
                    {"p", "q", "r", "s"},
                    {"t", "u", "v"},
                    {"w", "x", "y", "z"}
            };

    public List<String> letterCombinations(String digits) {
        final int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        return letterCombinations(n - 1, digits);
    }

    private List<String> letterCombinations(int k, String digits) {
        String[] currLetter = letterMap[Character.getNumericValue(digits.charAt(k))];
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
