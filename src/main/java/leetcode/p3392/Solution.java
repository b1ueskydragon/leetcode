package leetcode.p3392;

class Solution {
    // Contiguous non-empty sequence
    // length 3 such that the sum of the first and third numbers equals exactly half of the second number
    public int countSubarrays(int[] nums) {
        final int n = nums.length;
        int count = 0;
        for (int r = 2; r < n; r++) {
            int l = r - 2;
            if (nums[l + 1] == (nums[l] + nums[r]) * 2) {
                count++;
            }
        }
        return count;
    }
}
