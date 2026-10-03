package leetcode.p0022;

import java.util.ArrayList;
import java.util.List;

class Solution2026V2 implements Solution {
    private final List<String> gen = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return gen;
    }

    private void backtrack(StringBuilder sb, int openers, int closers, int n) {
        // condition of an end of the backtracking
        if (sb.length() == n * 2) {
            // condition of appending to the result
            if (openers == n && closers == n) {
                gen.add(sb.toString());
            }
            return;
        }
        sb.append("("); // choose
        backtrack(sb, openers + 1, closers, n); // counter (openers) will be reset after the recursion
        sb.deleteCharAt(sb.length() - 1); // reset the choice manually
        // e,g.,
        // () + ) : NG
        // ()( + ) : OK
        if (openers > closers) {
            sb.append(")");
            backtrack(sb, openers, closers + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
