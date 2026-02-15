package leetcode.p0067.s2026;

class Solution {
    public String addBinary(String a, String b) {
        final int n = a.length(); // The longer.
        final int m = b.length(); // The shorter.

        if (n < m) {
            return addBinary(b, a);
        }

        final int offset = n - m;
        final var sb = new StringBuilder();
        int carry = 0;

        for (int i = m - 1; i >= 0; i--) {
            int sum = carry + parse(a.charAt(i + offset)) + parse(b.charAt(i));
            if (sum > 1) {
                sb.append(sum - 2);
                carry = 1;
            } else {
                sb.append(sum);
                carry = 0;
            }
        }

        for (int i = offset - 1; i >= 0; i--) {
            int sum = carry + parse(a.charAt(i));
            if (sum > 1) {
                sb.append(sum - 2);
                carry = 1;
            } else {
                sb.append(sum);
                carry = 0;
            }
        }

        if (carry > 0) {
            // The most significant bit.
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    private static int parse(final char c) {
        return c - '0';
    }

}
