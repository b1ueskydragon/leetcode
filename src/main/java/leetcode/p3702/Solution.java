package leetcode.p3702;

class Solution {
    // self ^ self == 0 (--> XOR reversal)
    // 0 ^ self = self
    // A subsequence. Not a subarray.
    public int longestSubsequence(int[] nums) {
        int prefixXOR = 0;
        for (int num : nums) {
            prefixXOR ^= num;
        }
        if (prefixXOR > 0) {
            return nums.length;
        }
        for (int num : nums) {
            // num >= 0.
            // Removing at most one non-zero element makes the XOR non-zero.
            if ((prefixXOR ^ num) > 0) {
                return nums.length - 1;
            }
        }
        // All zeros.
        return 0;
    }
}
