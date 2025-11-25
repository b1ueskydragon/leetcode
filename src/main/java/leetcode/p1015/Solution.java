package leetcode.p1015;

class Solution {
    // n = 1 + 10^1 + 10^2 + ... ,
    // 1 <= k <= 10^5,
    // n / k
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        // R_1 = 1, R_2 = 11, R_3 = 111, ... ,
        // R_n+1 = (R_n * 10) + 1.
        // R_n+1 % k = ((R_n * 10) + 1) % k,
        // 大きい数字を縮めるために,
        // R_n+1 % k = (R_n % k * 10 + 1 % k) % k.
        // また, 余りには周期性があり, 最大でも k パターンのはず
        int rm = 1 % k;
        int i = 0;
        while (i <= k) {
            i++;
            if (rm == 0) {
                return i;
            }
            // Get next remainder from the current one.
            // R_n+1 % k = (R_n % k * 10 + 1 % k) % k
            rm = (rm % k * 10 + 1) % k;
        }
        return -1;
    }
}
