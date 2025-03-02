package leetcode.p2384;

class Solution {
    public String largestPalindromic(String num) {
        // Constrains: '0' ~ '9'
        final int[] table = new int[10];
        for (char c : num.toCharArray()) {
            // e.g. '1' - '0' = 1
            table[c - '0']++;
        }

        // all zeros
        if (table[0] == num.length()) {
            return "0";
        }

        final StringBuilder head = new StringBuilder();
        final StringBuilder body = new StringBuilder();

        // e.g. '9729' など一番大きい数字の '9' が2つ以上ならまずそれで両サイド挟みたい
        // 次に大きい数字を body にいれる
        // 9 + 7 + 9
        for (int i = 9; i >= 0; i--) {
            // we have already counted zero
            // we need to prevent appending zero to the head
            // e.g. '00000009',
            // final result will be head: "", body: "9"
            if (head.length() == 0 && i == 0) {
                continue;
            }

            while (table[i] >= 2) {
                head.append(i);
                table[i] = table[i] - 2;
            }

            // still exists && has a space in body
            if (table[i] == 1 && body.length() == 0) {
                body.append(i);
            }
        }

        final StringBuilder res = new StringBuilder();
        res.append(head);
        res.append(body);
        res.append(head.reverse());

        return res.toString();
    }
}
