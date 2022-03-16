package leetcode.p1249;

class Solution {
    // Goal is reducing parentheses, and it doesn't matter which will be removed.
    // Unless it is "", parentheses part can be in any form as long as they start '(' and close with ')'.
    // Hence, if the number of parentheses can be kept, an additional stack is not needed to keep parentheses itself.
    public String minRemoveToMakeValid(String s) {
        final char[] cs = s.toCharArray();
        int open = 0, close = 0;
        final char blank = ' ';
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ')') {
                close++;
                if (close > open) {
                    cs[i] = blank;
                    close--;
                }
                continue;
            }
            if (cs[i] == '(') {
                open++;
            }
        }

        // reverse order - to remove a last placed '('
        for (int i = cs.length - 1; i >= 0; i--) {
            if (open > close && cs[i] == '(') {
                cs[i] = blank;
                open--;
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c != blank) sb.append(c);
        }
        return sb.toString();
    }
}
