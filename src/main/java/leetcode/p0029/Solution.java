package leetcode.p0029;

class Solution {
    // Only +, - and bitwise are allowed
    //
    // e.g., 21 / 3
    //
    // 3 + 3 + 3 + 3 + 3 + 3 + 3 = 21
    // (3 + 3 + 3 + 3) + (3 + 3) + (3) = 21
    // (3 * 2^2) + (3 * 2^1) + (3 * 2^0) = 21
    // Answer should be 2^2 + 2^1 + 2^0 = 7
    //
    // However, we cannot use multiplication, so we need to convert it to bitwise ...
    // (3 << 2) + (3 << 1) + (3 << 0) = 21
    // Answer should be (1 << 2) + (1 << 1) + (1 << 0) = 7
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            // Edge case: Cannot handle in Integer range (return type should be int)
            return Integer.MAX_VALUE;
        }
        int acc = 0;
        // To prevent overflow of "negative Integer.MIN_VALUE"
        // (~k) + 1L == -1L * k
        long y = (dividend < 0) ? (~dividend) + 1L : dividend;
        // To prevent overflow of x << 1
        long x = (divisor < 0) ? (~divisor) + 1L : divisor;
        while (y >= x) {
            int i = 0;
            while (x <= y) {
                x <<= 1;
                i++;
            }
            y -= (x >> 1);
            if (i > 0) {
                acc += (1 << (i - 1));
            }
            x = (divisor < 0) ? (~divisor) + 1L : divisor;
        }
        return isPos(dividend, divisor) ? acc : (~acc) + 1;
    }

    private static boolean isPos(int dividend, int divisor) {
        return (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0);
    }
}
