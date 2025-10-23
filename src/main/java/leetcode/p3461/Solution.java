package leetcode.p3461;

class Solution {

    static class V1 {

        public boolean hasSameDigits(String s) {
            while (s.length() > 2) {
                s = operate(s);
            }
            return Integer.parseInt(s) % 11 == 0;
        }

        private String operate(String num) {
            final var sb = new StringBuilder();
            for (int i = 1; i < num.length(); i++) {
                final int d1 = num.charAt(i - 1) - '0';
                final int d2 = num.charAt(i) - '0';
                sb.append((d1 + d2) % 10);
            }
            return sb.toString();
        }
    }

}
