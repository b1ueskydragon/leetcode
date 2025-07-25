package leetcode.p3487;

class Solution {
    private static final int LIMIT = 100;

    public int maxSum(int[] nums) {
        // Unique, do not pick any negative number
        // -100 <= nums[i] <= 100
        // We will skip negative numbers to count frequencies
        final int[] freq = new int[LIMIT + 1];
        // If `nums` includes only negative numbers, we need to pick the max one
        int maxNeg = -(LIMIT + 1);
        for (int num : nums) {
            if (num < 0) {
                maxNeg = Math.max(maxNeg, num);
                continue;
            }
            freq[num]++;
        }

        int posSum = 0;
        for (int i = LIMIT; i >= 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            posSum += i;
        }

        // When `nums` does not include positive numbers or zero,
        // It indicates that only negative numbers are included in `nums`
        return (posSum == 0 && freq[0] == 0) ? maxNeg : posSum;
    }
}
