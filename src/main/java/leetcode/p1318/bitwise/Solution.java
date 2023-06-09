package leetcode.p1318.bitwise;

// Beats 100% Execution time
// No additional space used
class Solution {
    // a | b should be c
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        // continue as long as any digits remain
        while (a > 0 || b > 0 || c > 0) {
            // get the least significant bit
            final int lsbA = a & 1;
            final int lsbB = b & 1;
            final int lsbC = c & 1;
            if ((lsbA | lsbB) != lsbC) {
                // pattern 1: either one `1` can make `1`
                if ((lsbA | lsbB) == 0) {
                    cnt++;
                }
                // pattern 2: only both `0` can make `0`
                else {
                    if ((lsbA & lsbB) == 1) {
                        cnt += 2;
                    } else {
                        cnt++;
                    }
                }
            }
            // drop the least significant bit
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return cnt;
    }
}
