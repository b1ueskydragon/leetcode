package leetcode.p0136;

class Solution {
    // Every element appears TWICE except for one. Find that single one.
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            // this^this=0
            xor ^= num;
        }
        return xor;
    }
}
