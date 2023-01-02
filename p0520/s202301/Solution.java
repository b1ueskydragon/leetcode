package leetcode.p0520.s202301;

// Beats 100% runtime
class Solution {
    public boolean detectCapitalUse(String word) {
        final char[] chars = word.toCharArray();
        final int n = chars.length;
        final boolean isHeadCapital = Character.isUpperCase(chars[0]);
        int capitals = isHeadCapital ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (Character.isUpperCase(chars[i])) {
                capitals++;
            }
        }
        return capitals == n || capitals == 0 || (isHeadCapital && capitals == 1);
    }
}
