package leetcode.p3637;

class Solution {
    public boolean isTrionic(int[] nums) {
        final int n = nums.length;
        if (n < 4) {
            return false;
        }

        // nums[q...n − 1] is strictly increasing.
        int q = n - 1;
        while (q > 0 && nums[q - 1] < nums[q]) {
            q--;
        }
        if (q == n - 1) {
            return false;
        }

        // nums[0...p] is strictly increasing.
        int p = 0;
        while (p < n - 1 && nums[p] < nums[p + 1]) {
            p++;
        }
        if (p == 0) {
            return false;
        }

        if (p > q) {
            return false;
        }

        // nums[p...q] is strictly decreasing.
        int prev = nums[p++];
        while (p <= q) {
            int curr = nums[p++];
            if (prev <= curr) {
                return false;
            }
            prev = curr;
        }

        return true;
    }
}
