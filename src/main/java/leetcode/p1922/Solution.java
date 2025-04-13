package leetcode.p1922;

class Solution {

    // (a x b) mod M = ((a mod M) x (b mod M)) mod M
    private final static int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // 5 patterns are available on `even position`: 0,2,4,6,8
        // if length n is odd  (n=5) : 5 * 4 * 5 * 4 * 5
        //                even (n=4) : 5 * 4 * 5 * 4
        long evenRes = modPow(5, (n + 1) / 2) % MOD;
        // 4 patterns are available on `odd position` : 2,3,5,7
        long oddRes = modPow(4, n / 2) % MOD;
        long res = (evenRes * oddRes) % MOD;
        return (int) res % MOD;
    }

    // base^k
    private static long modPow(long base, long k) {
        long acc = 1;

        while (k > 0) {
            if (k % 2 == 0) {
                // Even k, base^k = (base * base)^(k/2)
                base = (base * base) % MOD;
                // Only reduce the exponent. never apply % MOD to k
                k /= 2; // (k>>=1) is also valid
            } else {
                // Odd k, base^k = base * base^(k-1)
                acc = (acc * base) % MOD;
                k--;
            }
        }
        return acc % MOD;
    }
}
