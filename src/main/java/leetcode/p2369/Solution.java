package leetcode.p2369;

class Solution {
    // Constraints
    // 2 <= nums.length <= 100_000
    public boolean validPartition(int[] nums) {
        // base case
        if (nums.length <= 3) {
            return isValidRule(nums);
        }
        // recursive case
        return (validPartition(split(nums, 0, 2)) && validPartition(split(nums, 2, nums.length)))
                || (validPartition(split(nums, 0, 3)) && validPartition(split(nums, 3, nums.length)));
    }

    private static boolean isValidRule(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        if (nums.length == 3) {
            if (nums[0] == nums[1] && nums[0] == nums[2]) {
                return true;
            }
            return nums[0] == nums[1] - 1 && nums[0] == nums[2] - 2;
        }
        return false;
    }

    private int[] split(int[] xs, int startIncl, int endExcl) {
        final int[] newXs = new int[endExcl - startIncl];
        int j = 0;
        for (int i = startIncl; i < endExcl; i++) {
            newXs[j++] = xs[i];
        }
        return newXs;
    }
}
