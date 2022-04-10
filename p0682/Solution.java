package leetcode.p0682;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calPoints(String[] ops) {
        final Deque<Integer> dq = new ArrayDeque<>();
        int acc = 0; // to reduce an operation of sum all
        for (String v : ops) {
            switch (v) {
                case "D":
                    acc += operateD(dq);
                    continue;
                case "C":
                    acc -= operateC(dq);
                    continue;
                case "+":
                    acc += operatePlus(dq);
                    continue;
                default: // This wil be a numeric value 
                    acc += operateNum(dq, v);
            }
        }
        return acc;
    }

    // It is guaranteed there will always be a previous score
    private static int operateD(Deque<Integer> dq) {
        dq.addLast(dq.peekLast() * 2);
        return dq.peekLast();
    }

    // It is guaranteed there will always be a previous score    
    private static int operateC(Deque<Integer> dq) {
        return dq.pollLast();
    }

    // It is guaranteed there will always be two previous scores                       
    private static int operatePlus(Deque<Integer> dq) {
        final int prev1 = dq.pollLast();
        final int prev2 = dq.pollLast();
        dq.addLast(prev2);
        dq.addLast(prev1);
        dq.addLast(prev1 + prev2);
        return dq.peekLast();
    }

    private static int operateNum(Deque<Integer> dq, String v) {
        dq.addLast(Integer.valueOf(v));
        return dq.peekLast();
    }
}
