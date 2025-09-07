package leetcode.p1304;

class Solution {
    public int[] sumZero(int n) {
        final int[] res = new int[n];
        // e.g.,
        // n=1, [0]
        // n=2, [-1, 1] = [1, -1]
        // n=3, [-1, 0, 1] = [0, 1, -1]
        // n=4, [-2, -1, 1, 2] = [1, -1, 2, -2]
        // ...
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
