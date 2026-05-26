package leetcode.p3120;

class Solution {
    public int numberOfSpecialChars(String word) {
        // Less than Integer.MAX_VALUE.
        int x = 1 << 26;
        int y = 1 << 26;
        // 1 0 0 0 ... 0 0 0
        //   z y x ... c b a
        //   Z Y X ... C B A
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                x |= (1 << (c - 'A'));
            }
            if (c >= 'a' && c <= 'z') {
                y |= (1 << (c - 'a'));
            }
        }
        int bit = x & y;
        int count = 0;
        // MSB is a sentinel.
        while (bit > 1) {
            if ((bit & 1) == 1) {
                count++;
            }
            bit >>>= 1;
        }
        return count;
    }
}
