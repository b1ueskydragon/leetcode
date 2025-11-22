package leetcode.p3190;

class Solution {
    // In one operation, you can add or subtract 1 from any element of nums.
    // Return the minimum number of operations to make all elements of nums divisible by 3.
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            // Possible non-zero remainders = {1, 2}
            // Regardless of 1 or 2, one operation will result in a multiple of 3
            // e.g.,
            // 1 - 1 = 0, 0 % 3 = 0
            // 2 + 1 = 3, 3 % 3 = 0
            if (num % 3 != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
