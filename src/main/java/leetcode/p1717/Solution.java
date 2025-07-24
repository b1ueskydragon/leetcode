package leetcode.p1717;

import java.util.ArrayDeque;

class Solution {
    public int maximumGain(String s, int x, int y) {
        final var stack = new ArrayDeque<Character>(); // We will reuse the stack
        // Get a higher chance first
        final int higher = (x > y) ? getScore(s, stack, 'a', 'b', x) : getScore(s, stack, 'b', 'a', y);
        final var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        final String modifiedStr = sb.reverse().toString();
        // Get a remaining chance
        final int lower = (x > y) ? getScore(modifiedStr, stack, 'b', 'a', y) : getScore(modifiedStr, stack, 'a', 'b', x);
        return higher + lower;
    }

    private int getScore(String s, ArrayDeque<Character> stack, char a, char b, int score) {
        int acc = 0;
        for (char curr : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }
            char prev = stack.peek();
            if (prev == a && curr == b) {
                stack.pop();
                acc += score;
                // Do not put `curr` in the stack
            } else {
                stack.push(curr);
            }
        }
        return acc;
    }
}
