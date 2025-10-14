package leetcode.p3349;

import java.util.List;

class Solution {
    // nums[a..a+k-1], nums[b..b+k-1]
    // b = a + k
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        final int n = nums.size();
        // Increasing count left to right
        final int[] incCnt = new int[n];
        incCnt[n - 1] = 1;
        // Retrieve right to left to perform it in O(N) time
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                incCnt[i] = incCnt[i + 1] + 1;
            } else {
                incCnt[i] = 1;
            }
        }

        for (int a = 0; a < n - k; a++) {
            if (incCnt[a] >= k && incCnt[a + k] >= k) {
                return true;
            }
        }
        return false;
    }
}
