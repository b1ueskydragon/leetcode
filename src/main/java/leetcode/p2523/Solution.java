package leetcode.p2523;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Constraints: 1 <= num <= 1_000_000 (Note: In practice, max 1_000 loops are enough due to sqrt optimization...)
        final boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i < right + 1; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= right; i++) {
            if (!isPrime[i]) {
                continue;
            }
            int curr = i + i;
            while (curr <= right) {
                isPrime[curr] = false;
                curr += i;
            }
        }

        int prevPrime = -1;
        int gap = 1_000_000;
        int a = -1;
        int b = -1;
        for (int num = left; num < right + 1; num++) {
            if (!isPrime[num]) {
                continue;
            }
            if (num - prevPrime < gap) {
                a = prevPrime;
                b = num;
                gap = num - prevPrime;
            }
            prevPrime = num;
        }

        return (a == -1 || b == -1) ? new int[] { -1, -1 } : new int[] { a, b };
    }
}
