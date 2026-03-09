package leetcode.p1980.s2026;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private final Set<String> set = new HashSet<>();
    String cand = "";

    // 1 <= n <= 16
    // Find any missing number in [0, (1 << n) - 1]
    public String findDifferentBinaryString(String[] nums) {
        for (String num : nums) {
            set.add(num);
        }
        final int n = nums[0].length();
        backtracking(n, new StringBuilder());
        return cand;
    }

    private void backtracking(int n, StringBuilder sb) {
        if (sb.length() == n) {
            // Completed sb.
            if (!set.contains(sb.toString())) {
                cand = sb.toString();
            }
            return;
        }
        // Ingredients: {0, 1}
        for (int i = 0; i <= 1; i++) {
            // Already found, early return.
            if (!cand.equals("")) {
                return;
            }
            // Choose.
            sb.append(i);
            backtracking(n, sb);
            // Remove the current choice (to prepare the next choice).
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
