package leetcode.p0921;

import java.util.ArrayDeque;

class Solution2026 {
    public int minAddToMakeValid(String s) {
        final var stack = new ArrayDeque<Character>(); // should be closed
        int count = 0; // should be opened
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                count++;
            }
        }
        return count + stack.size();
    }
}
