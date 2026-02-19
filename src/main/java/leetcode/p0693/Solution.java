package leetcode.p0693;

class Solution {

    static class V1 {

        public boolean hasAlternatingBits(int n) {
            int prev = n & 1;
            n >>>= 1;
            while (n > 0) {
                final int lsb = n & 1;
                if (lsb == prev) {
                    return false;
                }
                prev = lsb;
                n >>>= 1;
            }
            return true;
        }

    }

    static class V2 {

        public boolean hasAlternatingBits(int n) {
            // (1) Merge bits
            //  10101010101
            // + 1010101010
            // --------------
            //  11111111111
            final int bits = n + (n >> 1);
            // (2) Check all bits are 1
            //    11111111111
            // & 100000000000
            // ----------------
            //              0
            return ((bits + 1) & bits) == 0;
        }

    }

}
