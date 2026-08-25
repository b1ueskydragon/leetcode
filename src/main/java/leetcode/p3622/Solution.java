package leetcode.p3622;

class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int mul = 1;
        int num = n;
        while (num > 0) {
            int d = num % 10;
            sum += d;
            mul *= d;
            num /= 10;
        }
        return n % (sum + mul) == 0;
    }
}
