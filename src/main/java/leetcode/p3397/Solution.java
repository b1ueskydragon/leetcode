package leetcode.p3397;

import java.util.Arrays;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long prev = (long) nums[0] - k;
        int ans = nums.length; // the maximum uniqueness
        for (int i = 1; i < nums.length; i++) {
            // Use long to prevent overflow; k can be up to 10^9
            long minPossible = (long) nums[i] - k;
            long maxPossible = (long) nums[i] + k;
            if (prev + 1 > maxPossible) {
                // e.g.,
                // nums=[1, 1, 1], k=0
                // unique: [1, _, _]
                //             ^
                //             2 以上が必要. しかし +k しても作れない
                ans--;
            } else {
                // e.g.,
                // 必ずしも prev=prev+1 ではないケース
                // nums=[1, 10, 20], k=5
                // unique: [1-5, 10-5, 20-5]
                // i=1, 10-5 > 1+1,
                // prev=10-5
                prev = Math.max(minPossible, prev + 1);
            }
        }
        return ans;
    }
}
