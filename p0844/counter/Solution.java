package leetcode.p0844.counter;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getValidString(s).equals(getValidString(t));
    }

    private static String getValidString(final String mixedStr) {
        final int last = mixedStr.length() - 1;
        final var sb = new StringBuilder();
        int del = 0;
        for (int i = last; i >= 0; i--) {
            final char x = mixedStr.charAt(i);
            if (x == '#') {
                del++;
                continue;
            }
            if (del == 0) {
                sb.append(x);
                continue;
            }
            del--;
        }
        return sb.toString();
    }
}
