package leetcode.p2048;

class Solution {
    // Due to the constraint 0 <= n <= 10^6,
    // The maximum balanced number is 1224444,
    // Brute force is acceptable.
    private static final int LIMIT = 1224444;
    private static final int MAX_D = 6;

    public int nextBeautifulNumber(int n) {
        for (int num = n + 1; num < LIMIT; num++) {
            if (isBalanced(num)) {
                return num;
            }
        }
        return LIMIT;
    }

    private static boolean isBalanced(int num) {
        final int[] freq = new int[MAX_D + 1];
        while (num > 0) {
            final int d = num % 10;
            if (d > MAX_D || d == 0) {
                // Cannot consist the balance number
                return false;
            }
            freq[d]++;
            if (freq[d] > d) {
                return false;
            }
            num /= 10;
        }
        for (int d = 1; d <= MAX_D; d++) {
            if (freq[d] == 0) {
                continue;
            }
            if (freq[d] != d) {
                return false;
            }
        }
        return true;
    }
}
