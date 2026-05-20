package leetcode.p2657;

class SolutionV1 implements Solution {
    // A permutation. should be unique.
    // 1 <= n <= 50
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // e.g,
        // [2,3,1]
        // [3,1,2]
        //
        // 2: 0100
        // 3: 1000
        // & ------
        //    0000 ... count 0
        //
        // 3: 1100
        // 1: 1010
        // & ------
        //    1000 ... count 1
        //
        // 1: 1110
        // 2: 1110
        // & ------
        //    1110 ... count 3
        final int n = A.length; // same as B.length
        final int[] ans = new int[n];
        long x = 0;
        long y = 0;
        for (int i = 0; i < n; i++) {
            final long a = A[i] * 1L;
            final long b = B[i] * 1L;
            x |= (1L << a);
            y |= (1L << b);
            // Count where both bits are 1
            long bit = x & y;
            int count = 0;
            while (bit > 0) {
                if ((bit & 1) == 1) {
                    count++;
                }
                bit >>>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}
