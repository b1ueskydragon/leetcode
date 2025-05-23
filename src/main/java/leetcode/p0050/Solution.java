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

    // Convert the recursion to the loop
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 41.7 MB, less than 81.47%

    /**
     * @param x Base number (底)
     * @param n Exponent (指数)
     * @return Exponentiation of x to the power of n
     */
    double myPow4(double x, int n) {
        // edge case (1)
        if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        }
        // Handle negative exponents by converting to positive
        // For any k>0: x^(-k) = (x^(-1))^k = (1/x)^k
        if (n < 0) {
            x = 1 / x;
            // edge case (2)
            // For any x!=-1: convert n to Integer.MAX_VALUE (approximate value) to prevent overflow
            // since given n is an int not a double
            n = (n == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -n;
        }
        // Base accumulator for odd exponent cases
        // Even if n starts as even, it will eventually become 1,
        // and the final result will be accumulated here
        double k = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                k *= x; // store the extra factor from odd exponent
            }
            // Whether n is even or odd, the digits can be properly shifted
            // Case of negative n (includes edge case of Integer.MIN_VALUE) has already been excluded
            n >>= 1;
            x *= x;
        }
        return k; // Return accumulated result
    }

    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 42.4 MB, less than 31.96%
    double myPow5(double x, int n) {
        // Handle negative exponents by converting to positive
        // For any k>0: x^(-k) = (x^(-1))^k = (1/x)^k
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        // Base accumulator for odd exponent cases
        // Even if n starts as even, it will eventually become 1,
        // and the final result will be accumulated here
        double k = 1;
        // using n!=0 instead n>0
        // since Integer.MIN_VALUE cannot be converted to positive properly
        while (n != 0) {
            if (n % 2 != 0) {
                k *= x; // store the extra factor from odd exponent
            }
            // For any odd n:
            //  ・(n-1)/2 is equivalent to n/2
            //  ・Avoid doing n-1 to prevent overflow case of Integer.MIN_VALUE
            //  ・store the extra multiplication in k
            n /= 2;
            x *= x;
        }
        return k; // Return accumulated result (n is now 0)
    }

    // Replace to the bit-operation from #myPow5
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 42.3 MB, less than 45.46%

    double myPow6(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double k = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                k *= x;
            }
            // Actually n >>= 1 works well, except the case of int n = Integer.MIN_VALUE
            n >>>= 1;
            x *= x;
        }
        return k;
    }
}
