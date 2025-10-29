package leetcode.p3370;

class Solution {

    static class V2 {

        public int smallestNumber(int n) {
            // Constraints: 1 <= n <= 1000
            int i = 1;
            while ((1 << i) - 1 < n) {
                i++;
            }
            return (1 << i) - 1;
        }

    }

    static class V1 {

        public int smallestNumber(int n) {
            int x = n;
            int i = 0;
            while (n > 0) {
                if ((n & 1) == 0) {
                    x |= (1 << i);
                }
                n >>= 1;
                i++;
            }
            return x;
        }

    }

}
