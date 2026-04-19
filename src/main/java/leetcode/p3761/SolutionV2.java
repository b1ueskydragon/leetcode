package leetcode.p3761;

import java.util.HashMap;
import java.util.Map;

class SolutionV2 implements Solution {
    // 方向性がある.
    // 120 -> 21 OK
    // 21 <- 120 NG
    public int minMirrorPairDistance(int[] nums) {
        // k=reversed num, v=an index where originally came from
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = nums.length;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null) {
                best = Math.min(best, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i); // update to the most recent index.
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private int reverse(int d) {
        int ans = 0;
        while (d > 0) {
            ans *= 10;
            ans += d % 10;
            d /= 10;
        }
        return ans;
    }
}
