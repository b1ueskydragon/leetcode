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
            // sum ∈ {3, 2, 1, 0}
            // appendable ∈ {1, 0}
            // 3 & 1 == 1
            // 2 & 1 == 0
            // 1 & 1 == 1
            // 0 & 1 == 0
            sb.append(sum & 1);
            // carry ∈ {1, 0}
            // 3 >> 1 == 1
            // 2 >> 1 == 1
            // 1 >> 1 == 0
            // 0 >> 1 == 0
            carry = sum >> 1;
        }

        for (int i = offset - 1; i >= 0; i--) {
            int sum = carry + parse(a.charAt(i));
            sb.append(sum & 1);
            carry = sum >> 1;
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
