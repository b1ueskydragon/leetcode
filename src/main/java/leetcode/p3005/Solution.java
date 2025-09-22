package leetcode.p3005;

class Solution {
    // 1 <= nums.length <= 100
    // 1 <= nums[i] <= 100
    public int maxFrequencyElements(int[] nums) {
        final int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int maxF = 0;
        int count = 0;
        for (int f : freq) {
            if (f == 0) {
                // Not a target
                continue;
            }
            if (f > maxF) {
                // Reset
                maxF = f;
                count = 1;
                continue;
            }
            if (f == maxF) {
                // Only count the current max
                count++;
            }
        }
        return maxF * count;
    }
}
