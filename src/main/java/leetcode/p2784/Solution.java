package leetcode.p2784;

class Solution {
    public boolean isGood(int[] nums) {
        // e.g.,
        // n=4, base=[1,2,3,3]
        final int n = nums.length;
        final int[] freq = new int[n];
        for (int num : nums) {
            if (num > n - 1) {
                return false;
            }
            freq[num]++;
        }
        if (freq[n - 1] != 2) {
            return false;
        }
        for (int num = 1; num < n - 1; num++) {
            if (freq[num] != 1) {
                return false;
            }
        }
        return true;
    }
}
