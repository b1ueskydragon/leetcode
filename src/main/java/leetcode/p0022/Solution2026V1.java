package leetcode.p0022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution2026V1 implements Solution {
    private final Map<Integer, List<String>> cache = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        // `1`: ()
        // `2`: `1``1`, (`1`)
        // `3`: `1``2`, `2``1`, (`2`)
        // `4`: `1``3`, `3``1`, `2``2`, (`3`)
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        if (n == 1) {
            // base case
            cache.put(1, List.of("()"));
            return cache.get(1);
        }
        final List<String> curr = new ArrayList<>();
        final Set<String> seen = new HashSet<>();
        for (int i = 1; i <= n / 2; i++) {
            final var left = generateParenthesis(n - i);
            final var right = generateParenthesis(i);
            for (String l : left) {
                for (String r : right) {
                    final String p1 = l + r; // e.g., n=5, build `3``2`
                    if (!seen.contains(p1)) {
                        curr.add(p1);
                        seen.add(p1);
                    }
                    final String p2 = r + l; // e.g., n=5, build `2``3`
                    if (!seen.contains(p2)) {
                        curr.add(p2);
                        seen.add(p2);
                    }
                }
            }
        }
        final var prev = generateParenthesis(n - 1);
        for (String s : prev) {
            final String p = "(" + s + ")";
            if (!seen.contains(p)) {
                curr.add(p);
                seen.add(p);
            }
        }
        cache.put(n, curr);
        return curr;
    }
}
