package leetcode.p2138;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        final int n = s.length();
        // ceil
        final int m = (n + (k - 1)) / k;
        final String[] res = new String[m];
        var sb = new StringBuilder();
        for (int i = 0; i < m * k; i++) {
            sb.append((i < n) ? s.charAt(i) : fill);
            if ((i + 1) % k == 0) {
                res[i / k] = sb.toString();
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
