package leetcode.p1404;

class Solution {
    public int numSteps(String s) {
        int count = 0;
        // Reuse the stringbuilder and utilize its methods in the whole process
        // to save the memory.
        final var sb = new StringBuilder(s);
        // s[0] == '1' due to the constraint, size 1 always be '1'.
        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '1') {
                addOne(sb);
            } else {
                rightShiftOnce(sb);
            }
            count++;
        }
        return count;
    }

    private void addOne(StringBuilder sb) {
        int carry = 1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int res = carry + sb.charAt(i) - '0';
            carry = (res > 1) ? 1 : 0;
            // Replace at index.
            sb.setCharAt(i, (char) ((res % 2) + '0'));

        }
        if (carry > 0) {
            // Append the carry to the head.
            sb.insert(0, carry);
        }
    }

    private void rightShiftOnce(StringBuilder sb) {
        // Remove the last.
        sb.setLength(sb.length() - 1);
    }
}
