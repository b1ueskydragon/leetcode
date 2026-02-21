package leetcode.p0762;

import java.util.Arrays;

class Solution {

    // 2 3 5 7 11 13 17 19 23 29 31
    private static final boolean[] IS_PRIME = checkPrime(32);

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = 0;
            int num = i;
            while (num > 0) {
                bits += (num & 1);
                num >>>= 1;
            }
            if (IS_PRIME[bits]) {
                count++;
            }
        }
        return count;
    }

    private static boolean[] checkPrime(int n) {
        final boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                // Seed num is already non-prime. No need to mark again its multiple nums.
                continue;
            }

            // If we start from i + i:
            // 2, 4, 6, 8, ...
            // 3, 6, 9, 12, ...
            // 5, 10, 15, 20, ...
            // However, i * 2, i * 3, ..., i * (i - 1) have already been marked by smaller prime factors.
            // Therefore, we can safely start from i * i.
            int num = i * i;
            while (num <= n) {
                isPrime[num] = false;
                num += i;
            }
        }
        return isPrime;
    }
}
