package leetcode.p0241;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return rec(expression);
    }

    private List<Integer> rec(String expression) {
        final int n = expression.length();
        List<Integer> splitPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                splitPoints.add(i);
            }
        }

        if (splitPoints.isEmpty()) {
            // base case
            List<Integer> base = new ArrayList<>();
            base.add(Integer.parseInt(expression));
            return base;
        }

        List<Integer> res = new ArrayList<>();
        for (int i : splitPoints) {
            List<Integer> left = rec(expression.substring(0, i));
            List<Integer> right = rec(expression.substring(i + 1, n));
            char op = expression.charAt(i);
            // 全ての組み合わせの merge が必要.
            for (int l : left) {
                for (int r : right) {
                    res.add(merge(op, l, r));
                }
            }
        }
        return res;
    }

    private int merge(char op, int l, int r) {
        return switch (op) {
            case '+' -> l + r;
            case '-' -> l - r;
            default -> l * r;
        };
    }
}
