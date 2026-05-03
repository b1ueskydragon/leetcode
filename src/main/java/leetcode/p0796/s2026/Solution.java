package leetcode.p0796.s2026;

class Solution {
    public boolean rotateString(String s, String goal) {
        final int n = s.length();
        final int m = goal.length();
        if (n != m) {
            return false;
        }
        final char head = goal.charAt(0);
        for (int j = 0; j < n; j++) {
            if (head == s.charAt(j) && isCycle(s, goal, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycle(String s1, String s2, int j) {
        final int n = s2.length();
        int i = 0;
        while (i < n) {
            if (s1.charAt(j++ % n) != s2.charAt(i++)) {
                return false;
            }
        }
        return true;
    }
}
