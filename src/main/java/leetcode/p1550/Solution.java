package leetcode.p1550;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int x : arr) {
            if ((x & 1) == 0) {
                cnt = 0; // reset
                continue;
            }
            if (++cnt == 3) {
                return true;
            }
        }
        return false;
    }
}
