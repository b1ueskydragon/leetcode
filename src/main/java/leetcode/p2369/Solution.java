package leetcode.p2369;

class Solution {
    // Constraints
    // 2 <= nums.length <= 100_000
    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0, nums.length);
    }

    // j is exclusive end
    private boolean validPartition(int[] nums, int i, int j) {
        // base case
        if (j - i <= 3) {
            return isValidRule(nums, i, j);
        }
        // recursive case
        return (validPartition(nums, i, i + 2) && validPartition(nums, i + 2, j))
                || (validPartition(nums, i, i + 3) && validPartition(nums, i + 3, j));
    }

    // j is exclusive end
    private static boolean isValidRule(int[] nums, int i, int j) {
        if (j - i == 2) {
            return nums[i] == nums[i + 1];
        }
        if (j - i == 3) {
            if (nums[i] == nums[i + 1]) {
                return nums[i] == nums[i + 2];
            } else if (nums[i] == nums[i + 1] - 1) {
                return nums[i] == nums[i + 2] - 2;
            }
        }
        return false;
    }
}
