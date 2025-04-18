package leetcode.p0038.s2025;

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = convert(res);
        }
        return res;
    }

    // e.g., "21" -> "1211"
    private String convert(String str) {
        final int n = str.length();
        final var sb = new StringBuilder();
        int l = 0;
        int r = 0;
        while (r < n) {
            if (str.charAt(l) == str.charAt(r)) {
                r++;
            } else {
                sb.append(r - l);
                sb.append(str.charAt(l));
                l = r;
            }
        }
        sb.append(r - l);
        sb.append(str.charAt(l));
        return sb.toString();
    }
}
