package leetcode.p1317;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (hasZeroDigit(i) || hasZeroDigit(n - i)) {
                continue;
            }
            // At most one is fine
            return new int[]{i, n - i};
        }
        return new int[]{-1, -1};
    }

    // k > 0
    private static boolean hasZeroDigit(int k) {
        while (k > 0) {
            if (k % 10 == 0) {
                return true;
            }
            k /= 10;
        }
        return false;
    }
}
