package leetcode.p2369;

class Solution {
    // isValidFrom[i] := whether a valid partition exists starting from the index i
    private Boolean[] isValidFrom;

    // Constraints
    // 2 <= nums.length <= 100_000
    public boolean validPartition(int[] nums) {
        isValidFrom = new Boolean[nums.length];
        return validPartition(nums, 0, nums.length);
    }

    // j is exclusive end
    private boolean validPartition(int[] nums, int i, int j) {
        // base case
        if (j - i <= 3) {
            return isValidRule(nums, i, j);
        }

        // recursive case
        // memoization
        if (isValidFrom[i] != null) {
            return isValidFrom[i];
        }

        // split case 1
        isValidFrom[i] = validPartition(nums, i, i + 2); // head (2 elements)
        isValidFrom[i + 2] = validPartition(nums, i + 2, j); // tail (remaining)

        if (isValidFrom[i] && isValidFrom[i + 2]) {
            return true;
        }

        // split case 2
        isValidFrom[i] = validPartition(nums, i, i + 3); // head (3 elements)
        isValidFrom[i + 3] = validPartition(nums, i + 3, j); // tail (remaining)
        return isValidFrom[i] && isValidFrom[i + 3];
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
        return false; // less than 2 elements. not enough to build a valid partition
    }
}
