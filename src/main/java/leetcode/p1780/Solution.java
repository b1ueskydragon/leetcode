package leetcode.p1780;

class Solution {
    // Convert to ternary number (3進数) first
    // - if we can represent number with only digit 0 and 1, return true
    // - if digit 2 mixed, return false
    public boolean checkPowersOfThree(int n) {
        // final int[] digits = new int[3]; // count 0, 1, 2

        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            // digits[n % 3]++;
            n /= 3;
        }

        // return digits[2] == 0;
        return true;
    }
}
