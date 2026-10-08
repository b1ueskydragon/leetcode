package leetcode.p1021;

import java.util.ArrayDeque;

class Solution {
    // s[i] is either '(' or ')'.
    // s is a valid parentheses string.
    public String removeOuterParentheses(String s) {
        final int n = s.length();
        // open to close
        final int[] map = new int[n + 1];
        final var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                map[stack.pop()] = i;
            }
        }
        final var sb = new StringBuilder();
        int o = 0;
        int c = map[0];
        // at o=0, always execute the first iteration to process the '('
        do {
            for (int i = o + 1; i < c; i++) {
                sb.append(s.charAt(i));
            }
            o = c + 1;
            c = map[o];
        } while (0 < o && o < n && 0 < c && c < n);
        return sb.toString();
    }
}
