package leetcode.p3723;

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // e.g.,
        // 6^2 > 5^2 + 1^2,
        // 6^2 > 3^2 + 2^2 + 1^1
        // Fill the left side with large digits.
        // e.g.,
        // num=100, sum=500,
        // "9"*55 + "5"*1 + "0"*44
        if (num * 9 < sum) {
            return "";
        }
        final var sb = new StringBuilder();
        final int niner = sum / 9;
        final int rem = sum % 9;
        sb.append("9".repeat(niner));
        if (sb.length() < num) {
            sb.append(rem);
        }
        sb.append("0".repeat(num - sb.length()));
        return sb.toString();
    }
}
