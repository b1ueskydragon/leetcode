package leetcode.p0326;

class Solution {

    static class V2 {

        public boolean isPowerOfThree(int n) {
            // The largest power of 3 (3^19) that fits in a 32-bit signed integer.
            // 1162261467 = 3*3*3*3*3*3*3*3*3*3*3*3*3*3*3*3*3*3*3
            // e.g.,
            // 9 = 3*3*3: can divide 3^19
            // 6 = 3*2: cannot divide 3^19 (2 will be remained)
            return n > 0 && 1162261467 % n == 0;
        }

    }

    static class V1 {

        public boolean isPowerOfThree(int n) {
            if (n == 1) {
                return true;
            }
            if (n <= 0) {
                return false;
            }
            if (n % 3 != 0) {
                return false;
            }
            return isPowerOfThree(n / 3);
        }

    }
}
