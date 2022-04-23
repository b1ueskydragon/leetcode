package leetcode.p0485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(res, count);
    }
}
