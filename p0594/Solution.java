package leetcode.p0594;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.computeIfAbsent(num, k -> 0) + 1);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!countMap.containsKey(num + 1)) {
                continue;
            }
            final int currLen = countMap.get(num) + countMap.get(num + 1);
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }
}
