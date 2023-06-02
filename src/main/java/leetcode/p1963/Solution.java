package leetcode.p1963;

class Solution {
    public int minSwaps(String s) {
        final int n = s.length();
        final char[] xs = s.toCharArray();
        int l = 0, r = n - 1;
        // track of the number of '[' and ']' on each step
        int open = 0, close = 0;
        int count = 0;
        while (l < r) {
            if (xs[l] == ']') close++;
            else open++;
            // make a swap if the number of closing brackets is ever larger
            if (close > open) {
                // find a right end '['
                while (xs[r] == ']') r--;

                char tmp = xs[r];
                xs[r] = xs[l];
                xs[l] = tmp;
                count++;

                close--;
                open++;
            }
            // proceed a cursor anyway
            l++;
        }
        return count;
    }
}
