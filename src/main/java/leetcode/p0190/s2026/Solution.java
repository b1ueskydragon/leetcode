package leetcode.p0190.s2026;

class Solution {
    // Reverse bits of a given 32 bits signed integer.
    // n is even, n >= 0.
    // つまり n は LSB が必ず 0, reverse した時負数にはならない.
    public int reverseBits(int n) {
        int bits = 0; // Significant bits.
        for (int i = 0; i < 32; i++) {
            bits <<= 1; // Note: first shift has no side effect.
            bits |= (n & 1);
            n >>>= 1; // この問題では due to the constraints, 実は n >>= 1 でも OK.
        }
        return bits;
    }
}
