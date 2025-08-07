package leetcode.p0043;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            // Edge case
            return "0";
        }

        final int n = num1.length();
        final int m = num2.length();

        // 123 * 456 (== 456 * 123)
        // == (3 * 6 * 1 * 1) + (3 * 5 * 1 * 10) + (3 * 4 * 1 * 100)
        //  + (2 * 6 * 10 * 1)  + (2 * 5 * 10 * 10) + (2 * 4 * 10 * 100)
        //  + (1 * 6 * 100 * 1) + (1 * 5 * 100 * 10) + (1 * 4 * 100 * 100)
        final int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            // '0' == 48
            final int a = num1.charAt(i) - 48;
            for (int j = m - 1; j >= 0; j--) {
                final int b = num2.charAt(j) - 48;

                final int p1 = i + j; // position for carry
                final int p2 = p1 + 1; // position for current digit

                // Max `a * b` is 81, so the product is always at most two digits
                // Accumulate into res[p2], carry over to res[p1]
                final int acc = (a * b) + res[p2];
                res[p2] = acc % 10;
                res[p1] += acc / 10;
            }
        }

        final var sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
