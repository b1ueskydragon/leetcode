package leetcode.p3304;

class Solution {
    public char kthCharacter(int k) {
        // max length 512, enough for 1 <= k <= 500
        final int[] xs = new int[1 << 9];
        xs[0] = 97; // should be started with 'a'
        gen(9, xs, 1);
        return (char) xs[k - 1];
    }

    // in-place
    private static void gen(int n, int[] xs, int offset) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < offset; i++) {
            // once the character reaches to 'z', it should be reset to 'a'
            final int next = xs[i] == 122 ? 97 : xs[i] + 1;
            xs[i + offset] = next;
        }
        gen(n - 1, xs, offset << 1);
    }
}
