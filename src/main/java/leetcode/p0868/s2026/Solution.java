package leetcode.p0868.s2026;

class Solution {
    public int binaryGap(int n) {
        int gap = 0;
        int index = 0;
        int prev = -1;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (prev != -1) {
                    gap = Math.max(gap, index - prev);
                }
                prev = index;
            }
            index++;
            n >>>= 1;
        }
        return gap;
    }
}
