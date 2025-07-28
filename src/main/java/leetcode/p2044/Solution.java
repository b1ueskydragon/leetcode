package leetcode.p2044;

class Solution {

    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // The OR of all elements gives the maximum OR value
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        // 1 <= nums.length <= 16
        // For each element: two choices (select or not select), max 2^16 subsets
        // Backtracking is feasible
        backtracking(nums, 0, maxOr, 0);
        return count;
    }

    private void backtracking(int[] nums, int i, int maxOr, int acc) {
        if (i == nums.length) {
            // Count only if we have reached the end of the array
            // (i.e., one subset has been fully constructed)
            if (acc == maxOr) {
                count++;
            }
            return;
        }
        // Select: choose current element
        backtracking(nums, i + 1, maxOr, acc | nums[i]);
        // Not select: Do not choose current element
        backtracking(nums, i + 1, maxOr, acc);
    }
}
