package leetcode.p2264;

class Solution {
    public String largestGoodInteger(String num) {
        final int n = num.length();
        char prev = 'a';
        int freq = 1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            final char curr = num.charAt(i);
            if (curr == prev) {
                freq++;
                if (freq >= 3) {
                    res = Math.max(res, curr - 48);
                }
            } else {
                freq = 1;
            }
            prev = curr;
        }
        return res == -1 ? "" : "%s%s%s".formatted(res, res, res);
    }
}
