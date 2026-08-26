package leetcode.p2904;

class Solution {
    // A substring of s is beautiful if the number of 1's in it is exactly k.
    // 1 <= n <= 100
    public String shortestBeautifulSubstring(String s, int k) {
        final int n = s.length();
        int l = 0;
        int r = 0;
        int count = 0;
        String ans = "";

        // How far from the nearest right side `1` from the current `0`.
        // GJ.
        final int[] suffixDist = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                suffixDist[i] = (s.charAt(i + 1) == '1') ? 1 : suffixDist[i + 1] + 1;
            }
        }
        while (l <= r && r < n) {
            // e.g.,
            // s = "100011001", k = 3,
            // Since finding the lexicographically smallest beautiful substring,
            // once 100011 (l=0, r=5) found, 1000110 (l=0, r=6) or 10001100 (l=0, r=7) are redundant.
            if (count < k) {
                if (s.charAt(r) == '1') {
                    count++;
                    if (count == k) {
                        // System.out.printf("%s %s %n",l, r);
                        // Remove the left side `0`s
                        final String cand = s.substring(l + suffixDist[l], r + 1);
                        if (ans.isBlank() || // the initial value
                                (ans.length() > cand.length()) || // the shorter, the smaller
                                (ans.length() == cand.length() && cand.compareTo(ans) < 0)) // same length, lexicographical order
                        {
                            ans = cand;
                        }
                    }
                }
                r++;
            } else {
                if (s.charAt(l) == '1') {
                    count--;
                }
                l++;
            }
        }
        return ans;
    }
}
