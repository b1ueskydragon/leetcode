package leetcode.p2401;

class Solution {
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
