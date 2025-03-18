package leetcode.p2401;

class Solution {
    static class V2 {
        public int longestNiceSubarray(int[] nums) {
            // A distance of a contiguous array
            // -> sliding window
            // if valid, expand (r++)
            // else, shrink (l++)
            int l = 0;
            int r = 0;
            int maxSoFar = 1; // Constraints: the minimum `nice` distance is 1.
            int acc = 0;  // Accumulated used bits `1` in the current window.
            while (r < nums.length) {
                // e.g.,
                // valid
                // 0101
                // 0010
                // 0011
                // -----------
                // 111 <--- 1 is added to each place at most once.
                //
                // not valid
                // 00[1]0 <--- [conflict]
                // 10 0 0
                // 00[1]1 <--- [conflict]
                // -----------
                // 10[1]1
                if ((acc & nums[r]) == 0) {
                    // Expand.
                    acc |= nums[r];
                    maxSoFar = Math.max(maxSoFar, r - l + 1);
                    r++;
                } else {
                    // Shrink.
                    // Remove nums[l] before shifting left.
                    //
                    // Note:
                    // XOR operation for removing bits is not exactly undoing the OR operation.
                    // It selectively removes only the bits that are uniquely used by the number being removed.
                    // e.g.,
                    // current window = 5,2,8,3 (l is on 5, r is on 3),
                    // When removing 5 (0101) from a window, we're only removing its 2nd and 4th bit positions
                    // from the OR accumulation, and that's enough.
                    // Although XOR does not fully reverse OR, it is sufficient because the leftmost number's
                    // unique bits are removed, and any remaining conflicts will be resolved in the next iterations.
                    acc ^= nums[l];
                    l++;
                }
            }
            return maxSoFar;
        }
    }

    static class V1 {
        public int longestNiceSubarray(int[] nums) {
            // a distance of a contiguous array
            // -> sliding window
            // if valid, expand (r++)
            // else, shrink (l++)
            int l = 0;
            int r = 1;
            int maxSoFar = 1; // Constraints: the minimum `nice` distance is 1.
            while (r < nums.length) {
                if (isValid(nums, l, r)) {
                    // expand
                    maxSoFar = Math.max(maxSoFar, r - l + 1);
                    r++;
                } else {
                    // shrink
                    l++;
                }
            }
            return maxSoFar;
        }

        private boolean isValid(int[] nums, int l, int r) {
            int i = l;
            while (i < r) {
                if ((nums[i] & nums[r]) != 0) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}
