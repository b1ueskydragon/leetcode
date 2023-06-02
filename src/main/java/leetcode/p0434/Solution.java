package leetcode.p0434;

class Solution {
    private static final char SPACE = ' ';

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            final char curr = s.charAt(i);
            if (prev != SPACE && curr == SPACE) {
                cnt++;
            }
            prev = curr;
        }
        return (prev != SPACE) ? cnt + 1 : cnt;
    }
}
