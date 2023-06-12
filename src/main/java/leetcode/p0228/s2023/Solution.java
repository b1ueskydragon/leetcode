package leetcode.p0228.s2023;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        final List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int prev = nums[0];
        int start = prev;
        for (int i = 1; i < nums.length; i++) {
            final int curr = nums[i];
            if (curr - prev != 1) {
                res.add(buildChunk(start, prev));
                start = curr;
            }
            prev = curr;
        }
        // flush
        res.add(buildChunk(start, prev));
        return res;
    }

    private static String buildChunk(int start, int end) {
        final var sb = new StringBuilder();
        if (start != end) {
            sb.append(start);
            sb.append("->");
        }
        sb.append(end);
        return sb.toString();
    }
}
