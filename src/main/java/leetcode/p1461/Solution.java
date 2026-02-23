package leetcode.p1461;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        final int n = s.length();
        if (n < k) {
            // Insufficient length.
            return false;
        }
        // substring で構成可能な場合, 必ず [0, (1 << k)] がピッタリ埋まる.
        // window を set#add して set#size == (1 << k) 比較も OK.
        final boolean[] seen = new boolean[1 << k];

        int window = 0;
        // An initial window.
        for (int i = 0; i < k; i++) {
            final int bit = s.charAt(i) - '0';
            window = (window << 1) | bit;
        }
        seen[window] = true;

        for (int i = k; i < n; i++) {
            final int bit = s.charAt(i) - '0';
            window = (window << 1) | bit;
            // 先頭が 1 の場合, 前の残りなので先頭の 1 をとる.
            // e.g.,
            // 110 -> 010
            if (window >= (1 << k)) {
                window -= (1 << k);
            }
            seen[window] = true;
        }

        for (boolean exists : seen) {
            if (!exists) {
                return false;
            }
        }
        return true;
    }
}
