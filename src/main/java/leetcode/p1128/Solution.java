package leetcode.p1128;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Constraint:
    // [a, b]
    // [c, d]
    // a == c and b == d
    // OR
    // a == d and b == c
    public int numEquivDominoPairs(int[][] dominoes) {
        final Map<String, Integer> freq = new HashMap<>();
        for (int[] domino : dominoes) {
            final String key = convertToKey(domino);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        int acc = 0;
        for (int n : freq.values()) {
            acc += combination(n);
        }
        return acc;
    }

    // Constraint: 1 <= dominoes[i][j] <= 9
    // Swap to ascendant order and concat to build a unique frequency key
    // At most 45 key types
    private static String convertToKey(int[] xs) {
        // += is too costly for String, using StringBuilder
        final var sb = new StringBuilder();
        sb.append(xs[0] < xs[1] ? xs[0] : xs[1]);
        sb.append(":");
        sb.append(xs[0] < xs[1] ? xs[1] : xs[0]);
        return sb.toString();
    }

    // nC2
    private static int combination(int n) {
        return n * (n - 1) / 2;
    }
}
