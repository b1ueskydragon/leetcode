package leetcode.p3507;

class Solution {
    // Since constraint is small (1 <= N <= 50), a straightforward simulation is feasible.
    public int minimumPairRemoval(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int center = 0; // index
        int minSum = nums[0] + nums[1];
        int prev = nums[0];
        boolean sorted = true;
        for (int i = 1; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            // If same, take the leftmost.
            if (sum < minSum) {
                minSum = sum;
                center = i;
            }
            if (prev > nums[i]) {
                sorted = false;
            }
            prev = nums[i];
        }
        if (prev > nums[n - 1]) {
            sorted = false;
        }
        if (sorted) {
            return 0;
        }

        int[] newNums = new int[n - 1];
        System.arraycopy(nums, 0, newNums, 0, center); // copy left
        newNums[center] = nums[center] + nums[center + 1]; // merge
        System.arraycopy(nums, center + 2, newNums, center + 1, n - (center + 2)); // copy right

        return 1 + minimumPairRemoval(newNums);
    }

}
