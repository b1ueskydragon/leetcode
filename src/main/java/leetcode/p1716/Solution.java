package leetcode.p1716;

class Solution {
    public int totalMoney(int n) {

        // 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
        // 2 + 3 + 4 + 5 + 6 + 7 + 8 = 28 + 7
        // 3 + 4 + 5 + 6 + 7 + 8 + 9 = 28 + 7 + 7
        // 4 +        ...        + 10
        // ...

        final int c = (1 + 7) * 7 / 2; // c=28
        final int q = n / 7;
        int res = 0;
        // c + c + 7 + c + 7 + 7 + ...
        // = (c + 7 * 0) + (c + 7 * 1) + (c + 7 * 2) + ...
        // = Σ(i=1 to q) (c + 7 * (i - 1))
        for (int i = 1; i <= q; i++) {
            res += c + (7 * (i - 1));
        }
        final int r = n % 7;
        // e.g.,
        // n=20
        // We already computed Σ(i=1 to 2) (c + 7 * (i - 1)) = 63
        // Then we need to add (3+4+5+6+7+8) using gaussian sum
        res += ((q + 1) + (q + r)) * r / 2;
        return res;
    }
}
