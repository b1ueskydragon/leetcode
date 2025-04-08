package leetcode.p3396;

class Solution {
    // Constraints: Remove 3 elements from the beginning of the array
    public int minimumOperations(int[] nums) {
        // Constraints: 1 <= nums[i] <= 100
        final int[] seen = new int[101];
        // Since the constraint is removing from the head,
        // scanning unique values from the last is efficient
        for (int i = nums.length - 1; i >= 0; i--) {
            seen[nums[i]]++;
            // Encountered the first duplication
            // No need to scan further
            if (seen[nums[i]] > 1) {
                // Note: ceil. n elements, divide by k, (n-1)/k +1
                return i / 3 + 1;
            }
        }
        return 0;
    }
}
