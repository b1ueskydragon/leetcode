package leetcode.p0682;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calPoints(String[] ops) {
        final Deque<Integer> dq = new ArrayDeque<>();
        int acc = 0; // to reduce an operation of sum all
        for (String v : ops) {
            switch (v) {
                // It is guaranteed there will always be a previous score
                case "D":
                    dq.addLast(dq.peekLast() * 2);
                    acc += dq.peekLast();
                    continue;
                    // It is guaranteed there will always be a previous score
                case "C":
                    final int x = dq.pollLast();
                    acc -= x;
                    continue;
                    // It is guaranteed there will always be two previous scores
                case "+":
                    final int prev1 = dq.pollLast();
                    final int prev2 = dq.pollLast();
                    dq.addLast(prev2);
                    dq.addLast(prev1);
                    dq.addLast(prev1 + prev2);
                    acc += dq.peekLast();
                    continue;
                    // This wil be a numeric value
                default:
                    dq.addLast(Integer.valueOf(v));
                    acc += dq.peekLast();
            }
        }
        return acc;
    }
}
