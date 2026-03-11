package leetcode.p1009;

class Solution {
    // Constraint: 0 <= n <= 10^9
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        // n = 10111
        // Get the full complement.
        //   111111...1 11111
        //  -           10111
        //    11111...1 01000
        int c = ((1 << 31) - 1) - n;

        // Mask bits to keep only the meaningful lower bits of n.
        //   11111...1 01000
        // & 000000..0 11111
        //             01000
        return c & ((1 << bitLength(n)) - 1);
    }

    private int bitLength(int n) {
        int len = 0;
        while (n > 0) {
            n >>>= 1;
            len++;
        }
        return len;
    }
}
