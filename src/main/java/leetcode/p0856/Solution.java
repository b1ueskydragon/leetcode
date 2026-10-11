package leetcode.p0856;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // s consists of only '(' and ')'.
    // s is a balanced parentheses string.
    public int scoreOfParentheses(String s) {
        // e.g.,
        // "((()()())(()))", index 0 to 13,
        // merging ranges as:
        // [2,3]
        // [2,3] -> [4,5]
        // [2,3] -> [4,5] -> [6,7]
        // [1,8]
        // [1,8] -> [10,11]
        // [1,8] -> [9,12]
        // [0,13]
        final int n = s.length();
        final var stack = new ArrayDeque<Integer>();
        // List of [l, r]
        final List<int[]> rangeOrder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                rangeOrder.add(new int[]{stack.pop(), i});
            }
        }
        // List of [l, r, score]
        final var scoreStack = new ArrayDeque<int[]>();
        for (int[] range : rangeOrder) {
            int l = range[0];
            int r = range[1];
            if (scoreStack.isEmpty()) {
                // an initial status
                scoreStack.push(new int[]{l, r, 1});
                continue;
            }
            if (scoreStack.peek()[1] < l) {
                // add a non-overlapping range
                scoreStack.push(new int[]{l, r, 1});
                continue;
            }
            int sumScore = 0;
            while (!scoreStack.isEmpty() &&
                    l < scoreStack.peek()[0] && scoreStack.peek()[1] < r) {
                sumScore += scoreStack.peek()[2];
                // continue to pop while it meets the condition,
                // the current range includes the previous range
                scoreStack.pop();
            }
            scoreStack.push(new int[]{l, r, sumScore * 2});

        }
        int ans = 0;
        while (!scoreStack.isEmpty()) {
            ans += scoreStack.pop()[2];
        }
        return ans;
    }
}
