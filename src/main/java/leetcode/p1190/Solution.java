package leetcode.p1190;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // 1 <= s.length <= 2_000 so O(n^2) is feasible
    // s only contains lower case English characters and parentheses.
    // It is guaranteed that all parentheses are balanced.
    public String reverseParentheses(String s) {
        final int n = s.length();
        // To track the opening/closing pair indices
        final var stack = new ArrayDeque<Integer>();
        final List<int[]> ranges = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '(') {
                stack.push(r);
            }
            if (s.charAt(r) == ')') {
                final int l = stack.pop();
                ranges.add(new int[]{l, r});
            }
        }
        final char[] xs = s.toCharArray();
        for (int[] range : ranges) {
            int l = range[0] + 1;
            int r = range[1] - 1;
            while (l < r) {
                char tmp = xs[r];
                xs[r] = xs[l];
                xs[l] = tmp;
                l++;
                r--;
            }
        }
        final var sb = new StringBuilder();
        for (char c : xs) {
            if (c != '(' && c != ')') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
