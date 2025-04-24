package leetcode.p2799;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // Constraints:
    // - 重複してもいいので全ての要素を一つ以上含む
    // - A subarray is a contiguous non-empty part of an array
    public int countCompleteSubarrays(int[] nums) {
        // contiguous array, sliding window

        final Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        final int uniqueLen = unique.size();

        final int n = nums.length;
        int l = 0;
        int r = 0;

        // Current window's seen numbers
        // 1 <= nums[i] <= 2000
        final int[] currFreq = new int[2001];
        int currUniqueLen = 0;
        int count = 0;

        while (r < n) {
            if (currFreq[nums[r]] == 0) {
                // The very fresh number came
                currUniqueLen++;
            }
            // Seen
            currFreq[nums[r]]++;

            while (currUniqueLen == uniqueLen) {
                // If valid, 残りの要素全てが valid
                // e.g.,
                // 1,3,1,2,2
                // l     r
                // Both 1,3,1,2 and 1,3,1,2,2 are valid
                //
                // 1,3,1,2,2
                //   l   r
                // Both 3,1,2 and 3,1,2,2 are valid
                count += (n - r);

                currFreq[nums[l]]--;
                if (currFreq[nums[l]] == 0) {
                    // また次の探索で見つけるしかない...
                    currUniqueLen--;
                }
                l++;
            }

            // While currUniqueLen < uniqueLen (Not valid yet)
            // expand a current window
            r++;
        }
        return count;
    }
}
