package leetcode.p1323;

// Beats 100% time execution
class Solution {
    // Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6)
    public int maximum69Number(int num) {
        int digit = 0;
        int tmp = num;
        int offset = 0;
        while (tmp > 0) {
            if (tmp % 10 == 6) {
                offset = 3 * (int) Math.pow(10, digit);
            }
            digit++;
            tmp /= 10;
        }
        return num + offset;
    }
}
