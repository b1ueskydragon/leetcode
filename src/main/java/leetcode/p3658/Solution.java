package leetcode.p3658;

class Solution {
    public int gcdOfOddEvenSums(int n) {

        // sumOdd  =  1 + 3 + 5 + 7 + 9 + ... + (2n - 1)
        // sumEven =  2 + 4 + 6 + 8 + 10 + ... + 2n
        // sumEven =  sumOdd + n

        // sumOdd  =  (1 + (2n - 1)) * n / 2
        //         =  n * n
        // sumEven =  (2 + 2n) * n / 2
        //         =  (n + 1) * n

        // n and n + 1 are coprime (互いに素)
        // so the GCD is n.

        return n;
    }
}
