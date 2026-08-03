package leetcode.p3754;

class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long k = 1;
        while (n > 0) {
            long d = (long) (n % 10);
            if (d > 0) {
                x += k * d;
                k *= 10;
            }
            sum += d;
            n /= 10;
        }
        return x * sum;
    }
}
