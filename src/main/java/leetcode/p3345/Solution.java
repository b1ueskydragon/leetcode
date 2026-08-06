package leetcode.p3345;

class Solution {
    // 1 <= n <= 100
    // 1 <= t <= 10
    public int smallestNumber(int n, int t) {
        if (n % 10 == 0) {
            // the product of digits is 0.
            // the answer won't be bigger than 100.
            return n;
        }
        int a = (n < 10) ? 1 : n / 10;
        int b = n % 10;
        while ((a * b) % t != 0) {
            n++;
            a = (n < 10) ? 1 : n / 10;
            b = n % 10;
        }
        return n;
    }
}
