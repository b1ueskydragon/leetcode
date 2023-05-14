package leetcode.p0434;

class Solution {
    private static final char SPACE = ' ';

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        final char[] chars = s.toCharArray();
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            final char curr = chars[i];
            if (prev != SPACE && curr == SPACE) {
                cnt++;
            }
            prev = chars[i];
        }
        return (prev != SPACE) ? cnt + 1 : cnt;
    }
}
