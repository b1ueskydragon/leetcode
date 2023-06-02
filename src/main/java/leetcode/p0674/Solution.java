package leetcode.p0674;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int lcis = 0;
        int cand = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            if (prev < num) {
                cand++;
            } else {
                lcis = Math.max(lcis, cand);
                cand = 1; // next count-up starts from this position
            }
            prev = num;
        }
        return Math.max(lcis, cand);
    }
}
