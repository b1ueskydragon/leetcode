package leetcode.p2243;

class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int i = 0;
            int sum = 0;
            final int tail = s.length() % k;
            final var sb = new StringBuilder();
            while (i < s.length()) {
                final int d = s.charAt(i) - '0';
                sum += d;
                if ((i + 1) % k == 0) {
                    sb.append(sum);
                    sum = 0;
                }
                i++;
            }
            // flush
            if (tail > 0) {
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }
}
