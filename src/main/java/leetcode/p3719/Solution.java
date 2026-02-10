package leetcode.p3719;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // n <= 1500, O(n^2) is feasible.
    public int longestBalanced(int[] nums) {
        final int n = nums.length;
        int maxLen = 0;

        Set<Integer> evens;
        Set<Integer> odds;

        for (int i = 0; i < n; i++) {
            if (n - i < maxLen) {
                // Left (i) 固定なので, これ以上作れない.
                return maxLen;
            }
            evens = new HashSet<>();
            odds = new HashSet<>();
            for (int j = i; j < n; j++) {
                final int num = nums[j];
                if ((num & 1) == 0) {
                    evens.add(num);
                } else {
                    odds.add(num);
                }
                if (evens.size() == odds.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                if (maxLen == n) {
                    return maxLen;
                }
            }
        }
        return maxLen;
    }
}
