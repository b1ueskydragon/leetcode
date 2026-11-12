package leetcode.p3105;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        final int n = nums.length;
        final int[] prefix = new int[n];
        final int[] prefixDesc = new int[n];
        prefix[0] = 1;
        prefixDesc[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] < nums[i] ? prefix[i - 1] + 1 : 1;
            prefixDesc[i] = nums[i - 1] > nums[i] ? prefixDesc[i - 1] + 1 : 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(
                    max, Math.max(prefix[i], prefixDesc[i])
            );
        }
        return max;
    }
}
