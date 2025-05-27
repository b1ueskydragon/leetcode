package leetcode.p2894;

class Solution {
    public int differenceOfSums(int n, int m) {
        final int all = sum(n);

        // e.g.,
        // n=100, m=6
        // divisible = {6x1, 6x2, ... ,6x16}
        //           = 6 x (1+2+...+16)
        final int divisible = m * sum(n / m);

        // (all - divisible) - divisible == non-divisible - divisible
        return all - 2 * divisible;
    }

    // sum-up 1 to n, n is inclusive
    private static int sum(int n) {
        return (1 + n) * n / 2;
    }
}
