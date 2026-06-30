package leetcode.p1358;

class Solution2026 implements Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        final int n = s.length();
        int count = 0;
        final int[] freq = new int[3];
        while (r < n) {
            freq[s.charAt(r) - 'a']++;
            if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Shrink the window while it valid.
                count += n - r; // [l, r], [l, r + 1], ... , [l, n - 1] are valid.
                freq[s.charAt(r) - 'a']--; // r is fixed, prevent to over-counting.
                freq[s.charAt(l) - 'a']--;
                l++;
            } else {
                // Expand the window while it is invalid.
                r++;
            }
        }
        return count;
    }
}
