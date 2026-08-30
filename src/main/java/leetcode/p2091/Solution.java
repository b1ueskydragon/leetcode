package leetcode.p2091;

class Solution {
    // The integers in nums are distinct.
    public int minimumDeletions(int[] nums) {
        final int n = nums.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // 3 patterns:
        // Remove all from the left.
        // Remove all from the right.
        // Remove from the left + Remove from the right.
        final int fromLeft = Math.max(minIndex + 1, maxIndex + 1);
        final int fromRight = Math.max(n - minIndex, n - maxIndex);
        final int fromBoth = Math.min(
                minIndex + 1 + (n - maxIndex), // minIndex < maxIndex
                maxIndex + 1 + (n - minIndex)  // minIndex > maxIndex
        );
        return Math.min(Math.min(fromLeft, fromRight), fromBoth);
    }
}
