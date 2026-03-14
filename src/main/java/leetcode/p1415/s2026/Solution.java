package leetcode.p1415.s2026;

class Solution {
    private int index = 1;
    private String res = "";

    public String getHappyString(int n, int k) {
        backtracking(n, k, new StringBuilder());
        return res;
    }

    // Fixed length backtracking
    private void backtracking(int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            // We've got a valid element.
            if (index++ == k) {
                res = sb.toString();
            }
            return;
        }
        if (!res.isEmpty()) {
            return;
        }
        // ingredients = {a, b, c}
        // 'a' + 0 = 'a'
        // 'a' + 1 = 'b'
        // 'a' + 2 = 'c'
        for (int i = 0; i < 3; i++) {
            final char curr = (char) ('a' + i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == curr) {
                // aab is NG
                // aba is OK
                continue;
            }
            // Choose.
            sb.append(curr);
            backtracking(n, k, sb);
            // Cancel the latest choice.
            sb.setLength(sb.length() - 1);
        }
    }
}
