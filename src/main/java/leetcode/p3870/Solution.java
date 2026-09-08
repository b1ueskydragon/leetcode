package leetcode.p3870;

class Solution {
    public int countCommas(int n) {
        if (n < 1_000) {
            return 0;
        }
        // [1_000, 1_000_000) = one comma per number.
        return n - 1_000 + 1;
    }
}
