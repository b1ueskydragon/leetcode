package leetcode.p2946;

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        // m rows.
        final int m = mat.length;
        // n numbers in each row.
        final int n = mat[0].length;
        // a minimum execution count.
        k %= n;
        if (k == 0) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (!isCyclic(mat[i], k)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(int[] row, int k) {
        final int n = row.length;
        final int repeat = ceil(n, k);
        for (int i = 0; i < k * repeat; i++) {
            if (row[i % n] != row[(i + k) % n]) {
                return false;
            }
        }
        return true;
    }

    private int ceil(int n, int k) {
        return (n + (k - 1)) / k;
    }
}
