package leetcode.p0050;


// Constraints:
//   -   -100.0 < x < 100.0
//   -   -2^31 <= n <= 2^31-1
//   -   n is an integer.
//   -   Either x is not zero or n > 0.
//   -   -10^4 <= x^n <= 10^4
class Solution {

    ///////////////////////////////////////// Initial Ideas /////////////////////////////////////////

    // Simple recursion
    //  n回掛け算をしなくて済むように、指数 n を可能な限り減らす
    //　if n is even:    n は偶数なので x を二乗し、n を半分にする
    //                   x^n = (x^2)^(n/2)
    //  else (n is odd): n を even にしたいので x を一つ外に出す
    //                   x^n = x * (x^2)^((n-1)/2)
    double myPow0(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return myPow0(x * x, n / 2);
        }
        // n can be simple
        // since `(n-1) / 2` is equal to `n / 2`
        return x * myPow0(x * x, (n - 1) / 2);
    }

    // Simple recursion
    // Replace minus to shift operation
    double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return myPow1(x * x, n / 2);
        }
        // no merit to use this in actual
        return x * myPow1(x * x, ((n >> 1) << 1) / 2);
    }

    // Tail-recursion like
    // Note: Java does not support tail-recursion optimization
    double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return myPow2helper(x, n, 1);
    }

    private double myPow2helper(double x, int n, double acc) {
        if (n == 0) {
            return acc;
        }
        if (n % 2 == 0) {
            return myPow2helper(x * x, n / 2, acc);
        }
        return myPow2helper(x * x, n / 2, acc * x);
    }

    ///////////////////////////////////////// Accepted Solutions /////////////////////////////////////////

    // Consider the negative n
    // n は負のままだと扱いづらいので、nは符号反転して x の逆数をとる
    // e.g.
    //      4^-2 = 4^-1 * 4^-1
    //           = 1/4 * 1/4
    //           = 0.25 * 0.25
    //           = 0.0625
    //      k>0,
    //      x^-k = 1/x * .. * 1/x (k回掛け算)
    //           = (1/x)^k
    //
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 42.4 MB, less than 38.35%
    double myPow3(double x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        // 指数反転
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }
        return myPow3helper(x, n, 1);
    }

    private double myPow3helper(double x, int n, double acc) {
        // base case
        if (n == 0) {
            return acc;
        }
        if (n % 2 == 0) {
            return myPow3helper(x * x, n / 2, acc);
        }
        return myPow3helper(x * x, n / 2, acc * x);
    }
}
