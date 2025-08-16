package leetcode.p0342;

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 &&
                // Check Power of Two
                (n & (n - 1)) == 0 &&
                // b'010101010101010101010101010101' == 715827882
                // e.g.,
                //     100
                // &   010
                // --------
                //     000
                //
                //   10000
                // & 01010
                // --------
                //   00000
                (n & 715827882) == 0;
    }
}
