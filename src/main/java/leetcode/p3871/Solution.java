package leetcode.p3871;

class Solution {
    public long countCommas(long n) {
        return rec(n, getK(n));

        // if (n < 1_000) {
        //     return 0;
        // }
        // if (n >= 1_000 && n < 1_000_000) {
        //     return n - 1_000 + 1;
        // }
        // if (n >= 1_000_000 && n < 1_000_000_000) {
        //     return (n - 1_000 + 1) + (n - 1_000_000 + 1);
        // }
        // if (n >= 1_000_000_000 && n < 1_000_000_000_000L) {
        //     return (n - 1_000 + 1) + (n - 1_000_000 + 1) + (n - 1_000_000_000L + 1);
        // }
        // if (n >= 1_000_000_000_000L && n < 1_000_000_000_000_000L) {
        //     return (n - 1_000 + 1) + (n - 1_000_000 + 1) + (n - 1_000_000_000L + 1) + (n - 1_000_000_000_000L + 1);
        // }
        // return (n - 1_000 + 1) + (n - 1_000_000 + 1) + (n - 1_000_000_000L + 1) + (n - 1_000_000_000_000L + 1) + (n - 1_000_000_000_000_000L + 1);
    }

    final long SEED = 1_000;

    private long rec(long n, long k) {
        if (n < SEED || k < SEED) {
            return 0;
        }
        final long prev = rec(n, k / SEED);
        return prev + n - k + 1;
    }

    // Get powers of 1_000, smaller or equal to n.
    private long getK(long n) {
        // n >= 1_000;
        if (n < SEED) {
            return 1L;
        }
        return getK(n / 1000L) * SEED;

        // if (n < SEED * SEED) {
        //     return SEED;
        // }
        // if (n < SEED * SEED * SEED) {
        //     return SEED * SEED;
        // }
        // if (n < SEED * SEED * SEED * SEED) {
        //     return SEED * SEED * SEED;
        // }
        // if (n < SEED * SEED * SEED * SEED * SEED) {
        //     return SEED * SEED * SEED * SEED;
        // }
        // return SEED * SEED * SEED * SEED * SEED;
    }
}
