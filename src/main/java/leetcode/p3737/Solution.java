package leetcode.p3737;

class Solution {
    // 1 <= nums.length <= 1000,
    // O(n^2) is feasible.
    public int countMajoritySubarrays(int[] nums, int target) {
        final int n = nums.length;
        final int[] prefixCount = new int[n];
        prefixCount[0] = nums[0] == target ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefixCount[i] = prefixCount[i - 1] + (nums[i] == target ? 1 : 0);
        }
        // e.g.,
        // 1, 2, 2, 3
        // i=0
        //
        // i=1
        //     2
        // i=2
        //  1, 2, 2
        //     2, 2
        //        2
        // i=3
        //     2, 2, 3
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                final int windowSize = i - j + 1;
                final int freq = j == 0 ? prefixCount[i] : prefixCount[i] - prefixCount[j - 1];
                if (freq * 2 > windowSize) {
                    count++;
                }
            }
        }
        return count;
    }
}
