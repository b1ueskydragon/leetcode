package leetcode.p0717;

class Solution {
    // Every bits ends with 0
    // The first character can be represented by one bit 0 (1 is invalid)
    // The second character can be represented by two bits, 10 or 11 (00, 01 are invalid)
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                i += 2;
                if (i == bits.length) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}
