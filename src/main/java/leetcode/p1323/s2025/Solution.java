package leetcode.p1323.s2025;

class Solution {
    // 1 <= num <= 10^4
    // `num` consists of only 6 and 9 digits
    // Changing at most one digit
    public int maximum69Number(int num) {
        // We need to change the leftmost `6` to `9`
        int x = num;
        int level = 1;
        int offset = 1;
        boolean allNines = true;
        while (x > 0) {
            int digit = x % 10;
            if (digit == 6) {
                // Update to the place value of the leftmost `6` seen so far
                offset = level;
                allNines = false;
            }
            level *= 10;
            x /= 10;
        }
        return allNines ? num : num - (offset * 6) + (offset * 9);
    }
}
