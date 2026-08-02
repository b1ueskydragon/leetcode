package leetcode.p3867;

import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        final int n = nums.length;
        int mx = nums[0]; // prefix max.
        final int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        for (int l = 0; l < n / 2; l++) {
            final int r = n - l - 1;
            final long v = gcd(prefixGcd[l], prefixGcd[r]) * 1L;
            sum += v;
        }
        return sum;
    }

    // Won't exceed Integer (1 <= num <= 10^9)
    // a >= b
    private int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
