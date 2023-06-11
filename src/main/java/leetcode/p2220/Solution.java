package leetcode.p2220;

class Solution {
    public int minBitFlips(int start, int goal) {
        int diff = start ^ goal;
        int one = 0;
        while (diff > 0) {
            one += (diff & 1);
            diff >>= 1;
        }
        return one;
    }
}
