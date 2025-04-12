package leetcode.p0008;

class Solution {
    public int myAtoi(String s) {
        // To prevent an Integer overflow
        long acc = 0;
        boolean isNeg = false;
        boolean headScanned = false;
        for (char c : s.toCharArray()) {
            // Leading Whitespaces
            if (acc == 0 && c == ' ') {
                if (headScanned) {
                    break;
                }
                continue;
            }
            // Signedness
            if (acc == 0 && (c == '-' || c == '+')) {
                if (headScanned) {
                    break;
                }
                isNeg = c == '-';
                headScanned = true;
                continue;
            }
            // (int) '0' == 48
            int number = c - 48;
            if (number < 10 && number >= 0) {
                headScanned = true;
                acc *= 10;
                acc += number;
                // Exceeded the range of Integer
                if (acc > Integer.MAX_VALUE) {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        return (int) (isNeg ? (~acc + 1) : acc);
    }
}
