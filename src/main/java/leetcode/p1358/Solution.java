package leetcode.p1358;

class Solution {
    public int numberOfSubstrings(String s) {
        // Constraints: 3 <= n <= 50000
        final int n = s.length();
        int l = 0;
        int r = 0; // we will expand r-side first so setting on zero is fine
        int res = 0;
        int[] abc = new int[3]; // 0=a, 1=b, 2=c
        while (r < n) {
            abc[s.charAt(r) - 'a']++;
            // Important: The window only needs to contain 'a', 'b', and 'c'; not be exactly "abc"
            while (abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
                // (1) Accumulate in the `while`
                // By shrinking the window from the left,
                // we count all valid substrings with different starting points
                // but the same ending point e.g., s[l:r], s[l+1:r], s[1+2:r], ... s[i:r] (s[i+1:r] won't be valid anymore)
                // (2) Adding (n-r)
                // Once we have a window containing a,b,c,
                // any rightward, every extension also contains a,b,c
                // For each valid window, there are (n-r) valid substrings ending at positions r, r+1, ..., n-1
                res += n - r;
                // shrink the current window
                abc[s.charAt(l) - 'a']--;
                l++;
            }
            // expand the window
            r++;
        }

        return res;
    }
}
