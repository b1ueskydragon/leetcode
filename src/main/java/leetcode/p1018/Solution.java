package leetcode.p1018;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        // Store only prefix % 5 rather than the full binary value.
        // When `a` is any big number, (b * a) % m == (b * (a % m)) % m
        // the remainder alone contains all information needed to update the prefix in the next step.
        final List<Boolean> ans = new ArrayList<>();
        int bit = 0;
        for (int num : nums) {
            bit |= num;
            bit %= 5; // 1 <= nums.length <= 10^5
            ans.add(bit == 0);
            bit <<= 1;
        }
        return ans;
    }
}
