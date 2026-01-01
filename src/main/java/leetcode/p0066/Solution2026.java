package leetcode.p0066;

class Solution2026 implements Solution {

    public int[] plusOne(int[] digits) {
        final int n = digits.length;
        digits[n - 1]++;

        if (digits[n - 1] < 9) {
            return digits;
        }

        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            }
        }
        if (carry == 0) {
            return digits;
        }

        final int[] ans = new int[n + 1];
        ans[0] = carry;
        // 1 = ans.length - digits.length
        System.arraycopy(digits, 0, ans, 1, n);
        return ans;
    }

}
