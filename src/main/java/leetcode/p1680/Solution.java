package leetcode.p1680;

class Solution {
    private static final long MOD = 1_000_000_007L;

    // 1 <= n <= 10^5
    // 10^5 < (1 << 17)
    // (MOD << 17) < Long.MAX_VALUE
    public int concatenatedBinary(int n) {
        // acc < MOD の限り, 安全.
        long acc = 0;
        // A Space to accommodate `num`. bitSize 分 left-shift して埋めていく.
        int bitSize = 1;
        // n -> 1 よりは 1 -> n の方が, acc に直接 MOD かけられるので acc < MOD が維持しやすい.
        for (long num = 1; num <= n; num++) {
            // Num increases monotonically (+1).
            // Easy to assume the bit-size.
            if (num >= (1L << bitSize)) {
                bitSize++;
            }
            // `x << bitSize` の計算が一番大きいので, Keep acc < MOD.
            acc = (acc << bitSize) + num;
            acc %= MOD;
        }
        return (int) acc;
    }
}
