package leetcode.p3350;

import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        final int n = nums.size();
        // maxLen[i] represents the length of the increasing subarray starting at nums[i]
        // (maxLen[i] corresponds to nums[i])
        final int[] maxLen = new int[n];
        maxLen[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                maxLen[i] = maxLen[i + 1] + 1;
            } else {
                maxLen[i] = 1;
            }
        }

        // 大きい size と小さい size が隣接している場合
        // 大きい size を２分割 (Case 1) するか, 小さい size に合わせるか (Case 2)

        // Case 1: Split one increasing subarray into two
        int candidate1 = 0;
        for (int i = 0; i < n; i++) {
            candidate1 = Math.max(candidate1, maxLen[i] / 2);
        }

        // Case 2: Two adjacent increasing subarrays
        int candidate2 = 0;
        int count = 1; // left to right, contiguous
        for (int i = 1; i < n; i++) {
            // Detect the boundary where the increasing run breaks
            if (nums.get(i - 1) < nums.get(i)) {
                count++;
                continue;
            }
            // 小さい size に合わせるけど, 現時点で最も大きい候補との比較も要る
            candidate2 = Math.max(candidate2, Math.min(count, maxLen[i]));
            count = 1; // reset
        }

        return Math.max(candidate1, candidate2);
    }
}
