package leetcode.p0416.s2025;

class Solution {

    /**
     * Backtracking + Memoization
     */
    static class V1 {
        // Constraint: 1 <= nums.length <= 200
        // Backtracking is too costly, we need a memo
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0) {
                return false;
            }

            // We need to use `null` value
            // Constraint: 1<= nums[i] <= 100, max sum is at most 20000
            final Boolean[][] memo = new Boolean[nums.length][20001];
            return isHalfTotal(0, nums, 0, sum, memo);
        }

        private boolean isHalfTotal(int i, int[] nums, int currSum, int totalSum, Boolean[][] canBuild) {
            // Pick or skip, anyway, reached to the leaf level
            if (i == nums.length) {
                return currSum * 2 == totalSum;
            }

            // Cannot build the totalSum, early return
            if (currSum > totalSum) {
                return false;
            }

            // key: i,currSum pair (since i position has various currSum patterns)
            // value: can build or not
            // Reduce duplicated tree retrieve
            if (canBuild[i][currSum] != null) {
                return canBuild[i][currSum];
            }

            // Pick
            boolean incl = isHalfTotal(i + 1, nums, currSum + nums[i], totalSum, canBuild);
            // Skip
            boolean excl = isHalfTotal(i + 1, nums, currSum, totalSum, canBuild);

            // Update the memo
            canBuild[i][currSum] = incl || excl;

            // At most one `true` is enough
            return incl || excl;
        }
    }

}
