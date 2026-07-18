package leetcode.p1979;

class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(min, max);
    }

    // x is the bigger, y is the smaller.
    private int gcd(int x, int y) {
        if (y > x) {
            return gcd(y, x);
        }
        if (x % y == 0) {
            return y; // can return 1.
        }
        return gcd(x % y, y);
    }
}
