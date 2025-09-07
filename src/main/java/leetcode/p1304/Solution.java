package leetcode.p1304;

class Solution {

    // Ensures uniqueness and total sum = 0
    // e.g.,
    // n=1, [0]
    // n=2, [-1, 1] or [1, -1]
    // n=3, [-1, 0, 1] or [0, 1, -1]
    // n=4, [-2, -1, 1, 2] or [1, -1, 2, -2]
    // n=5, [-2, -1, 0, 1, 2] or [0, 1, -1, 2, -2]
    // ...

    static class V2 {

        public int[] sumZero(int n) {
            final int[] res = new int[n];
            int k = 1;
            for (int i = 0; i < n / 2; i++) {
                // e,g,. n=4 or n=5
                res[i] = k; // index: 0, 1
                res[n - 1 - i] = -k; // index: 3, 2
                k++;
            }
            // Middle stays 0 if n is odd, since default array is filled with 0 in Java
            return res;
        }

    }

    static class V1 {

        public int[] sumZero(int n) {
            final int[] res = new int[n];
            if ((n & 1) == 0) {
                int k = 1;
                for (int i = 0; i < n; i = i + 2) {
                    res[i] = k;
                    res[i + 1] = -k;
                    k++;
                }
            } else {
                res[0] = 0;
                int k = 1;
                for (int i = 1; i < n; i = i + 2) {
                    res[i] = k;
                    res[i + 1] = -k;
                    k++;
                }
            }
            return res;
        }

    }
}
