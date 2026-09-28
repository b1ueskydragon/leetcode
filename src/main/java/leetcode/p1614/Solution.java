package leetcode.p1614;

import java.util.ArrayDeque;

class Solution {
    // All parentheses are valid.
    // Which means once the parenthesis opened, it will be closed eventually.
    public int maxDepth(String s) {
        final var stack = new ArrayDeque<Character>();
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                stack.pop();
                final int currDepth = stack.size(); // openers guarantee their closing.
                maxDepth = Math.max(maxDepth, currDepth + 1);
            }
        }
        return maxDepth;
    }
}
