package leetcode.p0020.s2026;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Open the most recent should be closed first.
        // Last in First out ... Stack.
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            final char curr = s.charAt(i);
            // Openers.
            // Only 3 patterns due to the constraint, hard-coding is still feasible instead of using a map.
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            }
            // Closers.
            else {
                // Nothing to close.
                if (stack.isEmpty()) {
                    return false;
                }
                final char opener = stack.pop();
                if (!isCorresponding(opener, curr)) {
                    return false;
                }
            }
        }
        // If not empty, openers are not closed enough.
        return stack.isEmpty();
    }

    private boolean isCorresponding(char opener, char closer) {
        return (opener == '(' && closer == ')') || opener == '{' && closer == '}' || opener == '[' && closer == ']';
    }
}
