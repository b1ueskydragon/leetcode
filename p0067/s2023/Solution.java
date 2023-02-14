package leetcode.p0067.s2023;

// Beats 100% time execution
class Solution {
    public String addBinary(String a, String b) {
        final int n = a.length();
        final int m = b.length();
        final int offset = Math.abs(n - m);
        return (n >= m) ? addBinary(a, b, n, offset) : addBinary(b, a, m, offset);
    }

    private String addBinary(String a, String b, int maxLen, int offset) {
        final StringBuilder sb = new StringBuilder();
        char acc = '0';
        int i;
        for (i = maxLen - 1; i >= 0; i--) {
            if (i - offset < 0) {
                break;
            }
            final char[] pair = getDigit(acc, a.charAt(i), b.charAt(i - offset));
            sb.append(pair[1]);
            acc = pair[0];
        }
        for (int j = i; j >= 0; j--) {
            final char[] pair = getDigit(acc, a.charAt(j), '0');
            sb.append(pair[1]);
            acc = pair[0];
        }
        if (acc == '1') {
            sb.append(acc);
        }
        return sb.reverse().toString();
    }

    // possible patterns
    private static char[] getDigit(char acc, char x, char y) {
        if (acc == '0' && x == '0' && y == '0') {
            return new char[]{'0', '0'};
        }
        if (acc == '0' && x == '0' && y == '1') {
            return new char[]{'0', '1'};
        }
        if (acc == '0' && x == '1' && y == '0') {
            return new char[]{'0', '1'};
        }
        if (acc == '0' && x == '1' && y == '1') {
            return new char[]{'1', '0'};
        }
        if (acc == '1' && x == '0' && y == '0') {
            return new char[]{'0', '1'};
        }
        if (acc == '1' && x == '0' && y == '1') {
            return new char[]{'1', '0'};
        }
        if (acc == '1' && x == '1' && y == '0') {
            return new char[]{'1', '0'};
        }
        if (acc == '1' && x == '1' && y == '1') {
            return new char[]{'1', '1'};
        }
        throw new IllegalArgumentException();
    }
}
