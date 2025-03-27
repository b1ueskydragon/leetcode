package leetcode.p2780;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Constraints: `nums` has exactly one dominant element.
    // We need the minimum index of a valid split.
    public int minimumIndex(List<Integer> nums) {
        // 1. Find the dominant element first
        // 2. Find the minimum separating point
        // e.g.,
        // [1,1,1,2,3,4,1,1]
        // The array has five `1`,
        // if left side has one `1`, then right side automatically has four `1`.
        final Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int mostFreqNum = -1;
        int mostFreqCount = 0;
        for (var entry : count.entrySet()) {
            if (mostFreqCount < entry.getValue()) {
                mostFreqCount = entry.getValue();
                mostFreqNum = entry.getKey();
            }
        }

        final int n = nums.size();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) != mostFreqNum) {
                continue;
            }
            leftCount++;
            rightCount = mostFreqCount - leftCount;
            final int leftSize = i + 1;
            final int rightSize = n - i - 1;
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}
