package leetcode.p3536;

class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int second = 0;
        while (n > 0) {
            final int d = n % 10;
            if (d >= second) {
                // Consider that first is always equal to or greater than second.
                second = d;
            }
            if (second >= first) {
                // Swipe to keep second <= first always.
                int tmp = first;
                first = second;
                second = tmp;
            }
            n /= 10;
        }
        return first * second;
    }
}
