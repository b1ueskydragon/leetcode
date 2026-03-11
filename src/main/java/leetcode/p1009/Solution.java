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
        return c & mask(n);
    }

    // e.g.,
    // n = 10101
    //    10101
    //  |  1010
    //    11111
    private int mask(int n) {
        // Propagate MSB (the highest set bit) to the right.
        // Repeating shifts by 1, 2, 4, 8, and 16 is enough
        // to cover all lower 31 bits in a 32-bit int.
        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);
        return n;
    }
}
