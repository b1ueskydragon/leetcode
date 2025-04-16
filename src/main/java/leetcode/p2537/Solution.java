package leetcode.p2537;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        final int n = nums.length;
        int l = 0;
        int r = 0;
        long pairs = 0;
        long subArrays = 0;
        while (r < n) {
            final int num = nums[r];
            final int prevCnt = freq.getOrDefault(num, 0);
            // Update frequency
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            final int currCnt = freq.get(num);
            if (currCnt > 1) {
                // Since we encountered the same number and the count was updated,
                // remove previous pair count and update to the new one
                pairs = pairs - combination(prevCnt) + combination(currCnt);
            }

            while (pairs >= k) {
                // No need to move `r` further,
                // Just count up patterns
                subArrays += (n - r);

                // Still we can try to shirink the window
                // Reset some status before move to the next window
                final int headNum = nums[l];
                final int headCnt = freq.get(headNum);
                pairs -= combination(headCnt);
                freq.put(headNum, freq.get(headNum) - 1);
                // Since moving `r` won't be back,
                // we need to update the pair count of new `nums[l]` at here
                // Current table.get(nums[l]) == headCnt - 1
                pairs += combination(headCnt - 1);
                l++;
            }

            r++;
        }

        return subArrays;
    }

    // cnt: The count of same numbers. How many pairs we can build
    // e.g.,
    // とある window が [2,3,2,2,1] の場合, valid num 2に注目,
    // 2の位置に関係なく2が3つ,
    // この window で作れる最大の valid pair は 3C2. この3C2を`k`と比べる
    private static long combination(int cnt) {
        // Constraint: 1 <= nums.length <= 100000
        // Max count of same num would be larger than Integer
        return (long) cnt * (cnt - 1) / 2;
    }
}
