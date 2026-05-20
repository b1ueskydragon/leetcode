package leetcode.p2657;

class SolutionV2 implements Solution {
    // A permutation. should be unique.
    // 1 <= n <= 50
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        final int n = A.length; // same as B.length
        final int[] ans = new int[n];
        final boolean[] x = new boolean[n + 1]; // seen A
        final boolean[] y = new boolean[n + 1]; // seen B
        int count = 0;
        for (int i = 0; i < n; i++) {
            final int a = A[i];
            final int b = B[i];
            if (a == b) {
                count++;
            } else {
                if (x[b]) {
                    count++;
                }
                if (y[a]) {
                    count++;
                }
            }
            ans[i] = count;
            x[a] = true;
            y[b] = true;
        }
        return ans;
    }
}
