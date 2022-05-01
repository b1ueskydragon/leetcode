package leetcode.p0844.stack;

import java.util.ArrayDeque;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getValidString(s).equals(getValidString(t));
    }

    private static String getValidString(final String s) {
        final ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        final var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
