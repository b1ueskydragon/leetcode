package leetcode.p3461;

class Solution {

    static class V2 {

        public boolean hasSameDigits(String s) {
            final int n = s.length();
            char[] num = s.toCharArray();
            // Perform (original s length - 2) operations
            for (int i = 0; i < n - 2; i++) {
                operate(num);
            }
            return num[0] == num[1];
        }

        // Modify array object itself, in-place
        private void operate(char[] num) {
            for (int i = 0; i < num.length - 1; i++) {
                final int d1 = num[i] - '0';
                final int d2 = num[i + 1] - '0';
                // Restore to char
                num[i] = (char) (((d1 + d2) % 10) + '0');
            }
        }

    }

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
