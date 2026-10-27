package leetcode.p3963;

class Solution {
    // Exactly one valid path from (0,0) to (m-1, n-1).
    // So doing this is also fine...
    // e.g.,
    // .....
    // ####.
    // ####.
    public String[] createGrid(int m, int n) {
        final String[] ans = new String[m];
        ans[0] = ".".repeat(n);
        final String others = "#".repeat(n - 1) + ".";
        for (int i = 1; i < m; i++) {
            ans[i] = others;
        }
        return ans;
    }
}
