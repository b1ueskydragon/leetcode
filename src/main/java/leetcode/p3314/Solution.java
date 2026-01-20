package leetcode.p3314;

import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        // x | (x + 1) := The operation which flips the least significant 0 to 1 in x.
        // e.g.,
        // binary num x,
        // x = 100, after the operation, 101
        // x = 011, after the operation, 100
        // x = 1001, after the operation, 1011
        final int[] ans = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            // 1 -> 0 candidates
            // e.g.,
            // binary num = 111,
            // candidates = (110, 101, 011)
            // 110 = 111 - (111 & 1) , 101 = 111 - (111 & 10), 011 = 111 - (111 & 100)
            int d = 1;
            // The break condition
            // e.g, 111 & 1000 = 0
            while ((num & d) > 0) {
                int cand = num - (num & d);
                if ((cand | (cand + 1)) == num) {
                    ans[i] = cand;
                }
                d <<= 1;
            }
            if (ans[i] == 0) {
                ans[i] = -1;
            }
            i++;
        }
        return ans;
    }
}
